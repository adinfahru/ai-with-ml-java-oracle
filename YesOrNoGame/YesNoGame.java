import java.util.Scanner;

class Node {
    String questionOrAnimal; // Bisa berupa pertanyaan atau jawaban (hewan)
    Node yesBranch;
    Node noBranch;

    public Node(String questionOrAnimal) {
        this.questionOrAnimal = questionOrAnimal;
        this.yesBranch = null;
        this.noBranch = null;
    }

    public boolean isLeaf() {
        return (yesBranch == null && noBranch == null);
    }
}

public class YesNoGame {
    final Node root;
    final Scanner scanner;

    public YesNoGame() {
        scanner = new Scanner(System.in);
        root = new Node("Is it a mammal?"); // Pertanyaan awal
        root.yesBranch = new Node("dog"); // Jawaban default jika jawaban "ya"
        root.noBranch = new Node("lizard"); // Jawaban default jika jawaban "tidak"
    }

    public void play() {
        System.out.println("Let's play a Yes/No game!");
        while (true) {
            playRound(root);
            System.out.print("Do you want to play again? (y/n): ");
            if (!getYesOrNo()) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    private void playRound(Node currentNode) {
        if (currentNode.isLeaf()) {
            // Jika sampai di daun, komputer menebak
            System.out.print("Is it a " + currentNode.questionOrAnimal + "? (y/n): ");
            if (getYesOrNo()) {
                System.out.println("I win!");
            } else {
                // Jika komputer salah, belajar dari kesalahan
                learnNewAnimal(currentNode);
            }
        } else {
            // Jika masih ada pertanyaan, lanjut bertanya
            System.out.print(currentNode.questionOrAnimal + " (y/n): ");
            if (getYesOrNo()) {
                playRound(currentNode.yesBranch);
            } else {
                playRound(currentNode.noBranch);
            }
        }
    }

    private void learnNewAnimal(Node currentNode) {
        System.out.println("You win. I give up. What were you thinking of?");
        String newAnimal = scanner.nextLine().trim();

        System.out.println("What question would you ask to differentiate a " + newAnimal + " from a "
                + currentNode.questionOrAnimal + "?");
        String newQuestion = scanner.nextLine().trim();

        System.out.println("What would the answer be for a " + newAnimal + "? (y/n): ");
        boolean answerForNewAnimal = getYesOrNo();

        // Simpan pengetahuan baru
        Node newQuestionNode = new Node(newQuestion);
        if (answerForNewAnimal) {
            newQuestionNode.yesBranch = new Node(newAnimal);
            newQuestionNode.noBranch = new Node(currentNode.questionOrAnimal);
        } else {
            newQuestionNode.noBranch = new Node(newAnimal);
            newQuestionNode.yesBranch = new Node(currentNode.questionOrAnimal);
        }

        // Gantikan node lama dengan node pertanyaan baru
        currentNode.questionOrAnimal = newQuestion;
        currentNode.yesBranch = newQuestionNode.yesBranch;
        currentNode.noBranch = newQuestionNode.noBranch;
    }

    private boolean getYesOrNo() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y"))
                return true;
            if (input.equals("n"))
                return false;
            System.out.print("Please enter 'y' or 'n': ");
        }
    }

    public static void main(String[] args) {
        YesNoGame game = new YesNoGame();
        game.play();
    }
}
