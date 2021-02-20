function performActions(){
    let str=document.getElementById("input1").value;
    console.log("String length is: "+ str.length);
    console.log("String in uppercase is: "+str.toUpperCase());
    console.log("String in lowercase is: "+str.toLowerCase());
    console.log("vowels are: "+str.match(/[aeiou]/gi)); 
    console.log("consonants are: "+str.match(/[^aeiou]/gi));
    let matches = str.match(/\d/);
    if (matches != null) {
        console.error("number is present inside string");
    }


    document.getElementById("length").innerText=("String length is: "+ str.length);
    document.getElementById("uppercase").innerText=("String in uppercase is: "+str.toUpperCase());
    document.getElementById("lowercase").innerText=("String in lowercase is: "+str.toLowerCase());
    document.getElementById("vowels").innerText=("vowels are: "+str.match(/[aeiou]/gi)); 
    document.getElementById("consonants").innerText=("consonants are: "+str.match(/[^aeiou0-9]/gi));
    if (matches != null) {
        document.getElementById("error").innerText=("number is present inside string");
    }
}