void main(){
    IO.println("Enter time in seconds: ");
    int seconds = Integer.parseInt(IO.readln());
    int hours = seconds/3600;
    seconds = seconds%3600;
    int minutes = seconds/60;
    seconds = seconds%60;
    IO.println("Hours: " + hours);
    IO.println("Minutes: " + minutes);
    IO.println("Seconds: " + seconds);

}