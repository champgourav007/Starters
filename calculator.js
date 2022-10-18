const express=require("express");
const bodyParser=require("body-parser");
const app=express();

app.use(bodyParser.urlencoded({extended: true}));
app.get("/",function(req,resp){
  //resp.send("Hello World");
  resp.sendFile(__dirname +"/index.html");
});
app.post("/",function(req,resp){
//  console.log(req.body);
//  console.log(req.body.num1);
var num1= Number(req.body.num1);
var num2= Number(req.body.num2);
var result=num1+num2;
  resp.send("After calculating result is : "+ result);
});

app.get("/bmicalculator",function(req,resp){
  //resp.send("Hello World");
  resp.sendFile(__dirname +"/bmiCalculator.html");
});

app.post("/bmicalculator",function(req,resp){
  var num1= parseFloat(req.body.weight);
  var num2= parseFloat(req.body.height);
  var result=num1/(num2 * num2);
    resp.send("Your BMI is: : "+ result);

});
app.listen(3000,function(){
  console.log("Server hosting on 3000");
});
