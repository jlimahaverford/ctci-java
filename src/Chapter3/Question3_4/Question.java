package Chapter3.Question3_4;

import Common.Stack;

public class Question {

    public static class HanoiMove {
        int from;
        int to;

        public HanoiMove(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public boolean willUndo(HanoiMove otherMove) {
            if (otherMove == null) {
                return false;
            }
            return (this.from == otherMove.to) && (this.to == otherMove.from);
        }

        public String toString() {
            return "(" + this.from + ", " + this.to + ")";
        }
    }

    public static HanoiMove[] POSSIBLE_MOVES = new HanoiMove[]{
            new HanoiMove(0, 1),
            new HanoiMove(1, 0),
            new HanoiMove(1, 2),
            new HanoiMove(2, 1)
    };

    public static class HanoiGame {
        Stack[] towers;
        HanoiMove lastMove;

        public HanoiGame(Stack[] towers, HanoiMove lastMove) {
            this.towers = towers;
            this.lastMove = lastMove;
        }

        int safePeek(int towerIndex) {
            int peekValue = Integer.MAX_VALUE;
            try {
                peekValue = this.towers[towerIndex].peek();
            } catch (RuntimeException e) {
                System.out.println("      Caught exception:" + e.getMessage());
            }

            return peekValue;
        }

        boolean isLegal(HanoiMove move) {
            System.out.println("    Testing move: " + move.toString());

            int fromSize = safePeek(move.from);
            int toSize = safePeek(move.to);

            if (toSize < fromSize) {
                return false;
            }

            if (move.willUndo(this.lastMove)) {
                return false;
            }

            return true;
        }

        void applyUpdate(HanoiMove move) {
            System.out.println("    Applying Update: " + move.toString());

            this.towers[move.to].push(this.towers[move.from].pop());
            this.lastMove = move;
        }

        public boolean isComplete() {
            return (this.towers[0].size() == 0) && (this.towers[1].size() == 0);
        }

        public void update() {
            for (HanoiMove move : POSSIBLE_MOVES) {
                if (isLegal(move)) {
                    applyUpdate(move);
                    break;
                }
            }
        }

        public String toString() {
            return "  Tower 0: " + towers[0].toString() +
                    "  Tower 1: " + towers[1].toString() +
                    "  Tower 2: " + towers[2].toString() +
                    "  Last Move: " + this.lastMove.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("Test #1:");
        Stack tower1 = Stack.fromArray(new int[]{5, 4, 3, 2, 1});
        Stack tower2 = new Stack();
        Stack tower3 = new Stack();
        Stack[] towers = new Stack[]{tower1, tower2, tower3};
        HanoiGame game = new HanoiGame(towers, new HanoiMove(1, 2));

        int  i = 0;

        while (!game.isComplete() && i < 1000) {
            System.out.println(game.toString());
            game.update();
            i ++;
        }
        System.out.println(game.toString());

        System.out.println("Run complete.");
    }
}

// NOTES
//
// 1) Misunderstood problem.  Thought one could only move from tower_i -> tower_{i+1} and vice versa.