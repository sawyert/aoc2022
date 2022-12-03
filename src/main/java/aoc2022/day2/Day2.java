package aoc2022.day2;

import java.util.HashMap;
import java.util.Map;

public class Day2 {
    private final String[] input;

    public Day2(String[] input) {
        this.input = input;
    }

    public long execute1() {
        Map<String,String> oppositePlays = new HashMap<>();
        oppositePlays.put("A", "R");
        oppositePlays.put("B", "P");
        oppositePlays.put("C", "S");

        Map<String,String> myPlays = new HashMap<>();
        myPlays.put("X", "R");
        myPlays.put("Y", "P");
        myPlays.put("Z", "S");

        Scores scores = new Scores();

        for (String line : this.input) {
            String oppositePlay = oppositePlays.get(""+line.charAt(0));
            String myPlay = myPlays.get(""+line.charAt(2));

            this.scoreRound(scores, oppositePlay, myPlay);
        }

        return scores.myScore;
    }

    public long execute2() {
        Map<String,String> oppositePlays = new HashMap<>();
        oppositePlays.put("A", "R");
        oppositePlays.put("B", "P");
        oppositePlays.put("C", "S");

        Map<String,String> myPlays = new HashMap<>();
        myPlays.put("X", "LOSE");
        myPlays.put("Y", "DRAW");
        myPlays.put("Z", "WIN");

        Scores scores = new Scores();

        for (String line : this.input) {
            String oppositePlay = oppositePlays.get(""+line.charAt(0));
            String myStrategy = myPlays.get(""+line.charAt(2));
            String myPlay = null;

            switch (myStrategy) {
                case "LOSE":
                    switch (oppositePlay) {
                        case "R":
                            myPlay = "S";
                            break;
                        case "P":
                            myPlay = "R";
                            break;
                        case "S":
                            myPlay = "P";
                            break;
                    }
                    break;
                case "WIN":
                    switch (oppositePlay) {
                        case "R":
                            myPlay = "P";
                            break;
                        case "P":
                            myPlay = "S";
                            break;
                        case "S":
                            myPlay = "R";
                            break;
                    }
                    break;
                case "DRAW":
                    myPlay = oppositePlay;
                    break;
            }


            this.scoreRound(scores, oppositePlay, myPlay);
        }

        return scores.myScore;
    }

    private void scoreRound(Scores scores, String oppositePlay, String myPlay) {
        final int LOSS = 0;
        final int DRAW = 3;
        final int WIN = 6;

        final int MY_ROCK = 1;
        final int MY_PAPER = 2;
        final int MY_SCISSORS = 3;

        switch (oppositePlay) {
            case "R":
                switch (myPlay) {
                    case "R":
                        scores.myScore += DRAW + MY_ROCK;
                        scores.oppositionScore += DRAW + MY_ROCK;
                        break;
                    case "P":
                        scores.myScore += WIN + MY_PAPER;
                        scores.oppositionScore += LOSS + MY_PAPER;
                        break;
                    case "S":
                        scores.myScore += LOSS + MY_SCISSORS;
                        scores.oppositionScore += WIN + MY_SCISSORS;
                        break;
                }
                break;
            case "P":
                switch (myPlay) {
                    case "R":
                        scores.myScore += LOSS + MY_ROCK;
                        scores.oppositionScore += WIN + MY_ROCK;
                        break;
                    case "P":
                        scores.myScore += DRAW + MY_PAPER;
                        scores.oppositionScore += DRAW + MY_PAPER;
                        break;
                    case "S":
                        scores.myScore += WIN + MY_SCISSORS;
                        scores.oppositionScore += LOSS + MY_SCISSORS;
                        break;
                }
                break;
            case "S":
                switch (myPlay) {
                    case "R":
                        scores.myScore += WIN + MY_ROCK;
                        scores.oppositionScore += LOSS + MY_ROCK;
                        break;
                    case "P":
                        scores.myScore += LOSS + MY_PAPER;
                        scores.oppositionScore += WIN + MY_PAPER;
                        break;
                    case "S":
                        scores.myScore += DRAW + MY_SCISSORS;
                        scores.oppositionScore += DRAW + MY_SCISSORS;
                        break;
                }
                break;
        }
    }
}
