void main(){
    double celsius = Double.parseDouble(IO.readln());
    double fahrenheit = celsius * 9 / 5 + 32;
    IO.println(celsius + " C is " + fahrenheit + " F");
}