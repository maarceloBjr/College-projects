let firstCard = 10
let secondCard = 11
let cards = [firstCard, secondCard];
let sum = firstCard + secondCard
let hasBlackJack = false
let isAlive = true
let message = "";

let messageEl = document.getElementById("message-el");
let sumEl = document.getElementById("sum-el");
let cardsEl = document.getElementById("cards-el");

function startGame(){
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

    messageEl.textContent = "Drawing a new card!"; 

    let newC = 6;

    cards.push(newC);
    
    sum = sum + newC;

    startGame(); 
}

