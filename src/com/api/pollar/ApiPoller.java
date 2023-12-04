package com.api.pollar;

import com.api.controller.EmployeeAPI;
import com.api.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ApiPoller {

    static ResourceBundle commonBundle = ResourceBundle.getBundle("common");

    static int Hello;
    static int welcome;
    static int employee;
    static int count;


    static {
        Hello = Integer.parseInt(commonBundle.getString("api.hello.poller"));
        welcome = Integer.parseInt(commonBundle.getString("api.welcome.poller"));
        employee = Integer.parseInt(commonBundle.getString("api.employee.poller"));
        count = Integer.parseInt(commonBundle.getString("api.count.poller"));


    }


    public void star() {
        Date date = new Date();
        Timer timer = new Timer();

        if (Hello > 0) {
            timer.schedule(new HelloPoller(), date, Hello);
        }
        if (welcome > 0) {
            timer.schedule(new WelcomePollerr(), date, welcome);
        }
        if (employee > 0) {
            timer.schedule(new EmployeePoller(), date, employee);
        } if (count > 0) {
            timer.schedule(new Count(), date, count);
        }



    }


    private class HelloPoller extends TimerTask {
        private  int count;
        @Override
        public void run() {
            count++;
            System.out.println("hello poller called "+count);

        }
    }

    private class WelcomePollerr extends TimerTask {
        private  int count;
        @Override
        public void run() {
            count++;
            System.out.println("Welcome poller called "+count);

        }
    }

    private class EmployeePoller extends TimerTask {


        @Override
        public void run() {
            try {
                EmployeeAPI api = new EmployeeAPI();
                api.getEmployees();

            } catch (ResourceNotFoundException e) {
                System.out.println("Employee is not present" + e.getMessage());


            }

        }
    }

    private class Count extends TimerTask{
        private  int count;
        @Override
        public void run() {
            count++;
            System.out.println("count: "+count);

            if(count==5){
                cancel();
                System.out.println("count: "+count);
            }


        }
    }
}




