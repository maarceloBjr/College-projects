
let sum;
let firstCard;
let secondCard;
let hasBlackJack = false;
let isAlive = true;
let message = "";
let gameStarted = false;
let cards = [];
let betAmount;


let messageEl = document.getElementById("message-el");
let finalMessageEl = document.getElementById("finalmessage-el");
let sumEl = document.getElementById("sum-el");
let cardsEl = document.getElementById("cards-el");
let playerEl = document.getElementById("player-el");
let startBtn = document.getElementById("start-btn");
let depositBtn = document.getElementById("deposit-btn");
let betBtn = document.getElementById("bet-btn");
let betEl = document.getElementById("bet-el");

let player = {
    name: "",
    credits: 0
}

function deposit(){
    player.name = document.getElementById("name-el").value;
    player.credits += Number(document.getElementById("credit-el").value);

    playerEl.textContent = player.name + ": $" + player.credits;

    return player;
}

startBtn = onClickStartBtn();

function withdraw(){
    if(player.credits < 100){
        finalMessageEl.textContent = "You withdrew $" + player.credits;
    }else if(player.credits < 500){
        finalMessageEl.textContent = "WOW! You withdrew $" + player.credits;
    }else{
        finalMessageEl.textContent = "YOU JUST WITHDREW THE ENORMOUS AMOUNT OF $" + player.credits;
    }
    player.credits = 0;
    playerEl.textContent = player.name + ": $" + player.credits;
}

function onClickStartBtn(){
    startBtn.disabled = true;
    startBtn.style.backgroundColor = 'red';
    startBtn.style.color = 'black';
    startBtn.style.opacity = 0.6;

    return startBtn;
}

function resetBtn(){
    startBtn.disabled = false;
    startBtn.style.backgroundColor = 'goldenrod';
    startBtn.style.color = '#016f32';
    startBtn.style.opacity = 1;
    startBtn.textContent = "START GAME";

    return startBtn;
}

function bet(){
    let betResult = window.confirm('Are you sure you want to bet?');
    if(betResult === true){
        startBtn = resetBtn();
        betAmount = Number(document.getElementById("bet-el").value);
        if(betAmount <= player.credits){
            player.credits -= betAmount;
            betEl.textContent = "You just betted $" + betAmount;
        }else{
            betEl.textContent = "You need to deposit or bet a lower amount of credit";
        }
    
        playerEl.textContent = player.name + ": $" + player.credits;
    }
}


function startGame(){
    firstCard = getRandomCard();
    secondCard = getRandomCard();
    sum = firstCard + secondCard;
    cards = [firstCard, secondCard];
    gameStarted = true;
    isAlive = true;
    hasBlackJack = false;
    startBtn = onClickStartBtn();
    renderGame();
}

function renderGame(){

    cardsEl.textContent = "Cards: " + cards.join(" ");
    
    sumEl.textContent = "Sum: " + sum;


    if (sum <= 20) {
        message = "Do you want to draw a new card? 🙂";
    } else if (sum === 21) {
        message = "Wohoo! You've got Blackjack! Bet to play again.";
        hasBlackJack = true;
        player.credits += (betAmount*1.5);
    } else {
        message = "You're out of the game! Bet to play again.";
        isAlive = false;
    }

    playerEl.textContent = player.name + ": $" + player.credits;
    messageEl.textContent = message;
}

function newCard(){

    
    if(isAlive === false){
        messageEl.textContent = "You can't draw a new card, you've already lost!";
        return;
    }else if(hasBlackJack === true){
        messageEl.textContent = "You can't draw a new card, you've already blackjacked!";
        return;
    }else if(gameStarted === false){
        return;
    }

    messageEl.textContent = "Drawing a new card!"; 

    let newC = getRandomCard();

    cards.push(newC);
    
    sum = sum + newC;

    renderGame(); 
}

function getRandomCard(){
    let randomCard = Math.floor(Math.random() * 13) + 1;
    if(randomCard >= 11 && randomCard <= 13 ){
        randomCard = 10;
    }else if(randomCard === 1){
        randomCard = 11;
    }
    return randomCard;
}

