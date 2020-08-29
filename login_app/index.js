var mysql = require("mysql");
var express = require("express");
var bodyParser = require("body-parser");

// connection to mysql
var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "groceries",
});

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.listen(3000, () => {
  console.log("Restful running on port 3000");
});

app.post("/register/", (req, res, next) => {
  var sqldata = req.body;
  var email = sqldata.email;
  var password = sqldata.password;

  con.query("SELECT * FROM user where email=?", [email], function (
    err,
    result,
    fields
  ) {
    con.on("error", (err) => {
      console.log("Error in Mysql", err);
    });

    if (result && result.length) {
      res.json("User already exist");
    } else {
      var sql = "INSERT INTO user (email,password) VALUES (?,?)";
      var values = [email, password];

      console.log(sql, values);

      con.query(sql, values, function (err, result, fields) {
        con.on("error", (err) => {
          console.log("[MySQL ERROR]", err);
        });
        res.json("Register Success");
        console.log("Registered" + sqldata);
      });
    }
  });
});

app.post("/login/", (req, res, next) => {
  var data = req.body;
  var email = data.email;
  var password = data.password;

  con.query("SELECT * FROM user where email = ?", [email], function (
    err,
    result,
    fields
  ) {
    con.on("error", (err) => {
      console.log("[MySQL ERROR]", err);
    });

    if (result && result.length) {
      if (password == result[0].password) {
        res.json(["Valid user"]);
      } else {
        res.json("Invalid user");
      }
    }
  });
});
