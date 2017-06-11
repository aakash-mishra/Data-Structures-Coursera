import java.io.*;
import java.util.*;

public class Brackets{

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    Stack stack = new Stack();
    String s = sc.nextLine();
    int len = s.length();
    char c[] = new char[len];
    c = s.toCharArray();
    int counter = 0;
    int unmatched= 0;
    int i=0;
    int index=0;
    for(i=0;i<len;i++){
      index++;

      if(c[i]=='{' || c[i]=='(' || c[i]=='['){
    //  System.out.println("Pushing");
      stack.push(c[i]);
      counter++;
    }


      else if(c[i]=='}' || c[i]==')' || c[i]==']'){
        if(c[i]==')' && !stack.empty() && (char)stack.peek()=='(' ){
        // System.out.println("Popping" + c[i]);
        stack.pop();
        counter--;
      }
         else if(c[i]==')' &&  !stack.empty() && (char)stack.peek()!='(' ){
          unmatched = i+1;
          break;
        }
        else if(c[i]==')' && stack.empty()){
         counter--;
         break;
       }


        else if(c[i]=='}' && !stack.empty() && (char)stack.peek()=='{' ){
          // System.out.println("Popping" + c[i]);
        stack.pop();
        counter--;
      }

       else if(c[i]=='}' && !stack.empty() && (char)stack.peek()!='{' ){
          unmatched = i+1;
          break;
        }
        else if(c[i]=='}' && stack.empty()){
         counter--;
         break;

       }

        else if(c[i]==']' && !stack.empty() && (char)stack.peek()=='[' ){
          // System.out.println("Popping" + c[i]);
        stack.pop();
        counter--;
      }

        else if(c[i]==']' && !stack.empty() &&  (char)stack.peek()!='[' ){
          unmatched = i+1;
          break;
        }
        else if(c[i]==']' && stack.empty()){
         counter--;
         break;

       }
      }

    }
    if(unmatched == 0 && counter == 0)
    System.out.println("Success");

    else if(counter!=0 && unmatched==0){
    System.out.println(index);
    //System.out.println("here");
  }

    else
    System.out.println(unmatched);
  }
}
