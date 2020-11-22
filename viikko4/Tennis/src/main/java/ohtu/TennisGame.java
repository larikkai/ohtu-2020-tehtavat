package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }
    
    public String getScore() {
        String score;
        if (onkoOtteluLoppu()) score = lisaaLoppuTilanne();
        else score = lisaaTilanne();
        return score;
    }
    
    private String lisaaTilanne() {
        if (onkoTasaTilanne()) {
            return lisaaTasaTilanne();
        } else if (onkoMahdollistaVoittaa() && onkoEtuTilanne()){
            return lisaaEtuTilanne();
        }
        return muuTilanne();
    }
    
    private boolean onkoTasaTilanne() {
        return player1Score==player2Score;
    }
    
    private String lisaaTasaTilanne() {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    
    private boolean onkoEtuTilanne() {  
        int score = player1Score-player2Score;
        return score ==1 || score == -1;
    }
    
    private boolean onkoMahdollistaVoittaa() {
        return player1Score >= 4 || player2Score >=4;
    }
    
    private String lisaaEtuTilanne() {
        int minusResult = player1Score-player2Score;
        if (minusResult==1) return "Advantage player1";
        return "Advantage player2";
    }
    
    private String muuTilanne() {
        String score = "";
        int tempScore=0;
        for (int i=1; i<3; i++) {
            if (i==1) tempScore = player1Score;
            else { 
                score+="-";
                tempScore = player2Score;
            }
            switch(tempScore) {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
    
    
    private boolean onkoOtteluLoppu() {
        if(player1Score >= 4 || player2Score >= 4) {
            int score = player1Score-player2Score;
            if(score >= 2 || score <= -2) {
                return true;
            }
        }
        return false;
    }
    
    private String lisaaLoppuTilanne() {
        int minusResult = player1Score-player2Score;
        if (minusResult>=2) return "Win for player1";
        return "Win for player2";
    }
    
}