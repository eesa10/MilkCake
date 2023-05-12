package com.sparta.mc;
class Node {
    private Employee employee;
    private Node left;
    private Node right;

	Node(Employee employee){
		this.employee=employee;
	}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}