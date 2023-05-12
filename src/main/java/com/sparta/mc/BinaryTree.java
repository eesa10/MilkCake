package com.sparta.mc;
class BinaryTree {
    private Node root;
    public void insert(Employee employee) {
        root = insertNode(root, employee);
    }

    private Node insertNode(Node current, Employee employee) {
        if (current == null) {
            return new Node(employee);
        }

        String currentLastName = current.getEmployee().getLastName();
        String newLastName = employee.getLastName();

        if (newLastName.compareTo(currentLastName) < 0) {
            current.setLeft(insertNode(current.getLeft(), employee));
        } else if (newLastName.compareTo(currentLastName) > 0) {
            current.setRight(insertNode(current.getRight(), employee));
        } else {
            // Handle duplicates (if required)
            // For example, you could have a list of employees with the same last name
            // stored in a separate data structure within the Node class
        }
        return current;
    }

    public Employee search(String lastName) {
        return searchNode(root, lastName);
    }

    private Employee searchNode(Node current, String lastName) {
        if (current == null || current.getEmployee().getLastName().equals(lastName)) {
            return (current != null) ? current.getEmployee() : null;
        }

        if (lastName.compareTo(current.getEmployee().getLastName()) < 0) {
            return searchNode(current.getLeft(), lastName);
        } else {
            return searchNode(current.getRight(), lastName);
        }
    }
}