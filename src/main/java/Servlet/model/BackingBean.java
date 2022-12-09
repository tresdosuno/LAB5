package Servlet.model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import java.util.Random;


@ManagedBean(name = "guessBean")

@ApplicationScoped
public class BackingBean {
    private int randomNumber, attemptNumber, attempts, prize;

    private String gameState;

    public BackingBean(){
        start();
    }

    private void start(){
        Random ran = new Random();
        this.randomNumber = ran.nextInt(10);
        this.attempts = 0;
        this.attemptNumber = 0;
        this.prize = 100000;
        this.gameState = "Perdiste.";
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getPrize() {
        return prize;
    }

    public String getGameState() {
        return gameState;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void setRandomNumber() {
        this.randomNumber = randomNumber;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public void guess (ActionEvent actionEvent){
        this.attempts+= 1;
        if(this.attemptNumber == this.randomNumber && this.attempts <= 10){
            this.gameState = "Ganaste, Premio: " + getPrize();
        }
        else{
            if(this.prize != 0){
                this.prize -= 10000;
            }
        }
    }

    public void restart(ActionEvent actionEvent){
        start();
    }

}
