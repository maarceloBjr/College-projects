
let sum;
let firstCard;
let secondCard;
let hasBlackJack = false;
let isAlive = true;
let message = "";
let gameStarted = false;
let cards = [];

let player = {
    name: "Marcelo",
    credits: 40
}

let messageEl = document.getElementById("message-el");
let sumEl = document.getElementById("sum-el");
let cardsEl = document.getElementById("cards-el");
let playerEl = document.getElementById("player-el");

playerEl.textContent = player.name + ": $" + player.credits;


function startGame(){
    firstCard = getRandomCard();
    secondCard = getRandomCard();
    sum = firstCard + secondCard;
    cards = [firstCard, secondCard];
    gameStarted = true;
    isAlive = true;
    hasBlackJack = false;
    renderGame();
}

function renderGame(){

    cardsEl.textContent = "Cards: " + cards.join(" ");
    
    sumEl.textContent = "Sum: " + sum;


    if (sum <= 20) {
        message = "Do you want to draw a new card? 🙂";
    } else if (sum === 21) {
        message = "Wohoo! You've got Blackjack! 🥳";
        hasBlackJack = true;
    } else {
        message = "You're out of the game! 😭";
        isAlive = false;
    }

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

