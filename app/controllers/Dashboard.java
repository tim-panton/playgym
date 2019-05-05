package controllers;

import play.Logger;
import play.mvc.Controller;
import models.Assessment;
import java.util.List;
import java.util.ArrayList;
import models.Member;



public class Dashboard extends Controller
{

  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Assessment> assessmentlist = member.assessmentlist;
    render ("dashboard.html", assessmentlist);
  }

  public static void addAssessment(Double weight, Double chest, Double thigh, Double upperArm, Double waist, Double hips)
  {
    Member member = Accounts.getLoggedInMember();
    Assessment assessment = new Assessment(weight, chest, thigh, upperArm, waist, hips);
    member.assessmentlist.add(assessment);
    member.save();
    Logger.info("Adding Todo " + weight + " " + chest + " " + thigh + " " + upperArm + " " + waist + " " + hips);
    redirect("/dashboard");
  }
}
