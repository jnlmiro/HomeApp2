package com.jorgma.homeapp.zwave.domain;

/**
 * Created by jorgma on 2018-07-30.
 */

public class ZwaveComponent {

    private String id;
    private String name;
    private String state;
    private int nodeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }


}
