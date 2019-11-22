package com.datastructure.ds.interview.treessgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

// O(P + D) time, P is the number of projects and D is the number of dependency pairs
public class BuildOrder2 {
    Stack<Project2> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph2 graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Stack<Project2> orderProjects(ArrayList<Project2> projects) {
        Stack<Project2> stack = new Stack<Project2>();

        for (Project2 project: projects) {
            if (project.getState() == Project2.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    boolean doDFS(Project2 project, Stack<Project2> stack) {
        if (project.getState() == Project2.State.PARTIAL) {
            return false;
        }

        if (project.getState() == Project2.State.BLANK) {
            project.setState(Project2.State.PARTIAL);
            ArrayList<Project2> children = project.getChildren();
            for (Project2 child: children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project2.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }

    Graph2 buildGraph(String[] projects, String[][] dependencies) {
        Graph2 graph = new Graph2();
        for (String project: projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }
}

class Graph2 {
    private ArrayList<Project2> nodes = new ArrayList<Project2>();
    private HashMap<String, Project2> map = new HashMap<String, Project2>();

    public Project2 getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project2 node = new Project2(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public ArrayList<Project2> getNodes() {
        return nodes;
    }

    public void addEdge(String firstStart, String secondEnd) {
        Project2 start = getOrCreateNode(firstStart);
        Project2 end = getOrCreateNode(secondEnd);
        start.addNeighbour(end);
    }
}


class Project2 {
    private ArrayList<Project2> children = new ArrayList<Project2>();
    private HashMap<String, Project2> map = new HashMap<String, Project2>();
    private String name;

    public enum State {COMPLETE, PARTIAL, BLANK}

    ;
    private State state = State.BLANK;

    public Project2(String n) {
        name = n;
    }

    public void addNeighbour(Project2 node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public void setState(State st) {
        state = st;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project2> getChildren() {
        return children;
    }
}