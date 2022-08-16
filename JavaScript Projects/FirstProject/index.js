let count = 0;
let countEl = document.getElementById("count-el");

function increment(){
    count++;
    countEl.innerText = count;
}

function save(){
    console.log("Saved!")
    console.log(count);
}

//https://www.youtube.com/watch?v=jS4aFq5-91M