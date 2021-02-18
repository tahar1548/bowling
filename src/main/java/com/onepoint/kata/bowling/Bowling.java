package com.onepoint.kata.bowling;

public class Bowling {

    private int[] lancee = new int[21];
    private int step = 0;

    public void knock(int pins) {
        lancee[step++] = pins;
    }

    public int getScore() {
        int score = 0;
        int posCounter = 0;

        for (int turn = 0; turn < 10; turn++) {
            if ( lancee[posCounter] == 10) { // case of strike
                score += 10 + lancee[posCounter + 1] + lancee[posCounter + 2];
                posCounter++;
            } else if (lancee[posCounter] + lancee[posCounter + 1] == 10) { //case of spare
                score += 10 + lancee[posCounter + 2];
                posCounter += 2;
            } else { // normal 
                score +=lancee[posCounter] + lancee[posCounter + 1];
                posCounter += 2;
            }
        }

        return score;
    }
}