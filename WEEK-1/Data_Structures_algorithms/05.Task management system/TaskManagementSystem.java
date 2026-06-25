class Task {

    int taskId;
    String taskName;
    String status;

    public Task(int taskId,
            String taskName,
            String status) {

        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

// Node for Singly Linked List

class TaskNode {

    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {

    private TaskNode head;

    // Add Task

    public void addTask(Task task) {

        TaskNode newNode = new TaskNode(task);

        if (head == null) {

            head = newNode;
        } else {

            TaskNode temp = head;

            while (temp.next != null) {

                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println(
                "Task added successfully.");
    }

    // Search Task

    public Task searchTask(int taskId) {

        TaskNode temp = head;

        while (temp != null) {

            if (temp.task.taskId == taskId) {

                return temp.task;
            }

            temp = temp.next;
        }

        return null;
    }

    // Traverse Tasks

    public void traverseTasks() {

        TaskNode temp = head;

        System.out.println(
                "\nTask List:");

        while (temp != null) {

            System.out.println(
                    "Task ID: "
                            + temp.task.taskId
                            + ", Task Name: "
                            + temp.task.taskName
                            + ", Status: "
                            + temp.task.status);

            temp = temp.next;
        }
    }

    // Delete Task

    public void deleteTask(int taskId) {

        if (head == null) {

            System.out.println(
                    "Task list is empty.");

            return;
        }

        if (head.task.taskId == taskId) {

            head = head.next;

            System.out.println(
                    "Task deleted successfully.");

            return;
        }

        TaskNode temp = head;

        while (temp.next != null &&
                temp.next.task.taskId != taskId) {

            temp = temp.next;
        }

        if (temp.next == null) {

            System.out.println(
                    "Task not found.");

            return;
        }

        temp.next = temp.next.next;

        System.out.println(
                "Task deleted successfully.");
    }

    public static void main(String[] args) {

        TaskManagementSystem manager = new TaskManagementSystem();

        manager.addTask(
                new Task(
                        101,
                        "Design Database",
                        "Pending"));

        manager.addTask(
                new Task(
                        102,
                        "Develop Backend",
                        "In Progress"));

        manager.addTask(
                new Task(
                        103,
                        "Testing",
                        "Pending"));

        manager.traverseTasks();

        System.out.println(
                "\nSearching Task ID 102:");

        Task found = manager.searchTask(102);

        if (found != null) {

            System.out.println(
                    "Task Found: "
                            + found.taskName
                            + " ("
                            + found.status
                            + ")");
        }

        System.out.println(
                "\nDeleting Task ID 102");

        manager.deleteTask(102);

        manager.traverseTasks();
    }
}