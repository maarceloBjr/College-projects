let randomNumber1 = Math.floor(Math.random() * 6) + 1;
let randomNumber2 = Math.floor(Math.random() * 6) + 1;

let randomDiceImage = "dice" + randomNumber1 + ".png";
let randomImageSource = "images/" + randomDiceImage;

let image1 = document.querySelectorAll("img")[0];
let image2 = document.querySelectorAll("img")[1];

image1.setAttribute("src", randomImageSource);

randomDiceImage = "dice" + randomNumber2 + ".png";
randomImageSource = "images/" + randomDiceImage;

image2.setAttribute("src", randomImageSource);


if(randomNumber1 > randomNumber2){
    document.querySelector("h1").innerText = "🎲 Player 1 wins!"
}else if(randomNumber1 < randomNumber2){
    document.querySelector("h1").innerText = "Player 2 wins! 🎲"
}else{
    document.querySelector("h1").innerText = "🎲 Draw! 🎲"
}
