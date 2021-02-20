// get details from ui
function getDetails() {
  this.fname = document.getElementById("fname").value;
  this.lname = document.getElementById("lname").value;
  this.age = document.getElementById("age").value;
  this.gender = document.querySelector('input[name="gender"]:checked')?.value;
  this.rno = document.getElementById("rno").value;
  this.dob = document.getElementById("dob").value;
  this.occ = document.getElementById("occ").value;
}

// checks if string is empty or not
function checkEmptyString(str) {
  if (typeof str === "undefined" || str.length === 0) {
    return {
      status: false,
      msg: "Please enter",
    };
  }
  return {
    status: true,
  };
}

// checks string does not contains number
function checkValidString(str) {
  if (typeof str === "undefined" || str.match(/\d/) != null) {
    return {
      status: false,
      msg: "Please enter valid",
    };
  }
  return {
    status: true,
  };
}

// checks if number > 0
function checkValidNumber(str) {
  if (typeof str === "undefined" || str < 0) {
    return {
      status: false,
      msg: "Please enter valid",
    };
  }
  return {
    status: true,
  };
}

// validate the details
function validateDetails(detailsObj) {
  for (const key in detailsObj) {
    let checkEmptyObj = checkEmptyString(detailsObj[key]);
    let checkValidObj = { status: true };
    if (key === "age" || key === "rno") {
      checkValidObj = checkValidNumber(detailsObj[key]);
    } else if (key !== "dob") {
      checkValidObj = checkValidString(detailsObj[key]);
    }
    if (checkEmptyObj.status === false || checkValidObj.status === false) {
      document.getElementById("v" + key).innerText =
        (checkEmptyObj.status === false
          ? checkEmptyObj.msg
          : checkValidObj.msg) +
        " " +
        document.getElementById(key).name;
      return false;
    }
  }
  return true;
}

// get details from ui, validates it and then perform accordingly
function submitForm(event) {
  event.preventDefault();

  // get details from ui
  let detailsObj = new getDetails();

  // validate details
  let validationResult = validateDetails(detailsObj);
  if (validationResult === true) {
    localStorage.setItem(detailsObj.rno, JSON.stringify(detailsObj));
    document.getElementById("form-status").classList.add("success-msg");
    document.getElementById("form-status").innerHTML =
      "form submitted successfully!!!";
  } else {
    document.getElementById("form-status").classList.add("error-msg");
    document.getElementById("form-status").innerHTML =
      "fill the form correctly........";
  }
}

// fetch the details from local storage
function fetchDetails() {
  let detailsElement = document.getElementById("details");
  detailsElement.innerText = "Fetching details...";
  setTimeout(() => {
    let rno = document.getElementById("fetch-no").value;
    detailsElement.innerHTML = localStorage.getItem(rno);
  }, 1000);
}
