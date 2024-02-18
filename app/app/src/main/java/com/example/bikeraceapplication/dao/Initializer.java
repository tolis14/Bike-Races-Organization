package com.example.bikeraceapplication.dao;



import com.example.bikeraceapplication.contacts.Email;
import com.example.bikeraceapplication.model.Competitor;
import com.example.bikeraceapplication.model.Organizer;
import com.example.bikeraceapplication.model.Participation;
import com.example.bikeraceapplication.model.Race;
import com.example.bikeraceapplication.model.RaceType;
import com.example.bikeraceapplication.model.Referee;
import com.example.bikeraceapplication.model.Role;
import com.example.bikeraceapplication.model.Sponsor;
import com.example.bikeraceapplication.model.SponsorshipApplication;
import com.example.bikeraceapplication.model.User;
import com.example.bikeraceapplication.util.Card;
import com.example.bikeraceapplication.util.Money;
import com.example.bikeraceapplication.util.Place;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Initializer {


    public void prepareData(){
        try {

            clearData();

            //DATA OF THE APPLICATION


            Card card = new Card();
            card.setBalance(545);

            User user0 = new User("Justin","Stallings",new Email("Justin0@gmail.com"),"Justin123",Role.COMPETITOR);
            Competitor competitor0 = new Competitor("Justin","Stallings",new Email("Justin0@gmail.com"),"Justin123",card);
            user0.setId("0");
            competitor0.setId("0");
            getUserDAO().save(user0);
            getCompetitorDao().save(competitor0);

            User user1 = new User("Curtis","Kennedy",new Email("Curtis1@gmail.com"),"Curtis123",Role.COMPETITOR);
            Competitor competitor1 = new Competitor("Curtis","Kennedy",new Email("Curtis1@gmail.com"),"Curtis123",card);
            user1.setId("1");
            competitor1.setId("1");
            getUserDAO().save(user1);
            getCompetitorDao().save(competitor1);

            User user2 = new User("Joel","Belew",new Email("Joel2@gmail.com"),"Joel123",Role.COMPETITOR);
            Competitor competitor2 = new Competitor("Joel","Belew",new Email("Joel2@gmail.com"),"Joel123",card);
            user2.setId("2");
            competitor2.setId("2");
            getUserDAO().save(user2);
            getCompetitorDao().save(competitor2);

            User user3 = new User("Michael","Stalcup",new Email("Michael3@gmail.com"),"Michael123",Role.COMPETITOR);
            Competitor competitor3 = new Competitor("Michael","Stalcup",new Email("Michael3@gmail.com"),"Michael123",card);
            user3.setId("3");
            competitor3.setId("3");
            getUserDAO().save(user3);
            getCompetitorDao().save(competitor3);

            User user4 = new User("Michael","Bullard",new Email("Michael4@gmail.com"),"Michael123",Role.COMPETITOR);
            Competitor competitor4 = new Competitor("Michael","Bullard",new Email("Michael4@gmail.com"),"Michael123",card);
            user4.setId("4");
            competitor4.setId("4");
            getUserDAO().save(user4);
            getCompetitorDao().save(competitor4);

            User user5 = new User("Steven","Martin",new Email("Steven5@gmail.com"),"Steven123",Role.COMPETITOR);
            Competitor competitor5 = new Competitor("Steven","Martin",new Email("Steven5@gmail.com"),"Steven123",card);
            user5.setId("5");
            competitor5.setId("5");
            getUserDAO().save(user5);
            getCompetitorDao().save(competitor5);

            User user6 = new User("Derek","Chapell",new Email("Derek6@gmail.com"),"Derek123",Role.COMPETITOR);
            Competitor competitor6 = new Competitor("Derek","Chapell",new Email("Derek6@gmail.com"),"Derek123",card);
            user6.setId("6");
            competitor6.setId("6");
            getUserDAO().save(user6);
            getCompetitorDao().save(competitor6);

            User user7 = new User("Nicholas","Adams",new Email("Nicholas7@gmail.com"),"Nicholas123",Role.COMPETITOR);
            Competitor competitor7 = new Competitor("Nicholas","Adams",new Email("Nicholas7@gmail.com"),"Nicholas123",card);
            user7.setId("7");
            competitor7.setId("7");
            getUserDAO().save(user7);
            getCompetitorDao().save(competitor7);

            User user8 = new User("Ken","Wendt",new Email("Ken8@gmail.com"),"Ken123",Role.COMPETITOR);
            Competitor competitor8 = new Competitor("Ken","Wendt",new Email("Ken8@gmail.com"),"Ken123",card);
            user8.setId("8");
            competitor8.setId("8");
            getUserDAO().save(user8);
            getCompetitorDao().save(competitor8);

            User user9 = new User("Christopher","Dickerman",new Email("Christopher9@gmail.com"),"Christopher123",Role.COMPETITOR);
            Competitor competitor9 = new Competitor("Christopher","Dickerman",new Email("Christopher9@gmail.com"),"Christopher123",card);
            user9.setId("9");
            competitor9.setId("9");
            getUserDAO().save(user9);
            getCompetitorDao().save(competitor9);

            User user10 = new User("Rodney","Galarza",new Email("Rodney10@gmail.com"),"Rodney123",Role.COMPETITOR);
            Competitor competitor10 = new Competitor("Rodney","Galarza",new Email("Rodney10@gmail.com"),"Rodney123",card);
            user10.setId("10");
            competitor10.setId("10");
            getUserDAO().save(user10);
            getCompetitorDao().save(competitor10);

            User user11 = new User("Quincy","Prater",new Email("Quincy11@gmail.com"),"Quincy123",Role.COMPETITOR);
            Competitor competitor11 = new Competitor("Quincy","Prater",new Email("Quincy11@gmail.com"),"Quincy123",card);
            user11.setId("11");
            competitor11.setId("11");
            getUserDAO().save(user11);
            getCompetitorDao().save(competitor11);

            User user12 = new User("Domingo","Farney",new Email("Domingo12@gmail.com"),"Domingo123",Role.COMPETITOR);
            Competitor competitor12 = new Competitor("Domingo","Farney",new Email("Domingo12@gmail.com"),"Domingo123",card);
            user12.setId("12");
            competitor12.setId("12");
            getUserDAO().save(user12);
            getCompetitorDao().save(competitor12);

            User user13 = new User("Scott","Leone",new Email("Scott13@gmail.com"),"Scott123",Role.COMPETITOR);
            Competitor competitor13 = new Competitor("Scott","Leone",new Email("Scott13@gmail.com"),"Scott123",card);
            user13.setId("13");
            competitor13.setId("13");
            getUserDAO().save(user13);
            getCompetitorDao().save(competitor13);

            User user14 = new User("Samuel","Clyne",new Email("Samuel14@gmail.com"),"Samuel123",Role.COMPETITOR);
            Competitor competitor14 = new Competitor("Samuel","Clyne",new Email("Samuel14@gmail.com"),"Samuel123",card);
            user14.setId("14");
            competitor14.setId("14");
            getUserDAO().save(user14);
            getCompetitorDao().save(competitor14);

            User user15 = new User("Sergio","Glass",new Email("Sergio15@gmail.com"),"Sergio123",Role.COMPETITOR);
            Competitor competitor15 = new Competitor("Sergio","Glass",new Email("Sergio15@gmail.com"),"Sergio123",card);
            user15.setId("15");
            competitor15.setId("15");
            getUserDAO().save(user15);
            getCompetitorDao().save(competitor15);

            User user16 = new User("Joseph","Miller",new Email("Joseph16@gmail.com"),"Joseph123",Role.COMPETITOR);
            Competitor competitor16 = new Competitor("Joseph","Miller",new Email("Joseph16@gmail.com"),"Joseph123",card);
            user16.setId("16");
            competitor16.setId("16");
            getUserDAO().save(user16);
            getCompetitorDao().save(competitor16);

            User user17 = new User("Richard","Long",new Email("Richard17@gmail.com"),"Richard123",Role.COMPETITOR);
            Competitor competitor17 = new Competitor("Richard","Long",new Email("Richard17@gmail.com"),"Richard123",card);
            user17.setId("17");
            competitor17.setId("17");
            getUserDAO().save(user17);
            getCompetitorDao().save(competitor17);

            User user18 = new User("Michael","Logan",new Email("Michael18@gmail.com"),"Michael123",Role.COMPETITOR);
            Competitor competitor18 = new Competitor("Michael","Logan",new Email("Michael18@gmail.com"),"Michael123",card);
            user18.setId("18");
            competitor18.setId("18");
            getUserDAO().save(user18);
            getCompetitorDao().save(competitor18);

            User user19 = new User("John","Sekel",new Email("John19@gmail.com"),"John123",Role.COMPETITOR);
            Competitor competitor19 = new Competitor("John","Sekel",new Email("John19@gmail.com"),"John123",card);
            user19.setId("19");
            competitor19.setId("19");
            getUserDAO().save(user19);
            getCompetitorDao().save(competitor19);

            User user20 = new User("Manuel","Kidd",new Email("Manuel20@gmail.com"),"Manuel123",Role.COMPETITOR);
            Competitor competitor20 = new Competitor("Manuel","Kidd",new Email("Manuel20@gmail.com"),"Manuel123",card);
            user20.setId("20");
            competitor20.setId("20");
            getUserDAO().save(user20);
            getCompetitorDao().save(competitor20);

            User user21 = new User("James","Franklin",new Email("James21@gmail.com"),"James123",Role.COMPETITOR);
            Competitor competitor21 = new Competitor("James","Franklin",new Email("James21@gmail.com"),"James123",card);
            user21.setId("21");
            competitor21.setId("21");
            getUserDAO().save(user21);
            getCompetitorDao().save(competitor21);

            User user22 = new User("Kevin","Kim",new Email("Kevin22@gmail.com"),"Kevin123",Role.COMPETITOR);
            Competitor competitor22 = new Competitor("Kevin","Kim",new Email("Kevin22@gmail.com"),"Kevin123",card);
            user22.setId("22");
            competitor22.setId("22");
            getUserDAO().save(user22);
            getCompetitorDao().save(competitor22);

            User user23 = new User("Thomas","Hattabaugh",new Email("Thomas23@gmail.com"),"Thomas123",Role.COMPETITOR);
            Competitor competitor23 = new Competitor("Thomas","Hattabaugh",new Email("Thomas23@gmail.com"),"Thomas123",card);
            user23.setId("23");
            competitor23.setId("23");
            getUserDAO().save(user23);
            getCompetitorDao().save(competitor23);

            User user24 = new User("Byron","Mackey",new Email("Byron24@gmail.com"),"Byron123",Role.COMPETITOR);
            Competitor competitor24 = new Competitor("Byron","Mackey",new Email("Byron24@gmail.com"),"Byron123",card);
            user24.setId("24");
            competitor24.setId("24");
            getUserDAO().save(user24);
            getCompetitorDao().save(competitor24);

            User user25 = new User("John","Love",new Email("John25@gmail.com"),"John123",Role.COMPETITOR);
            Competitor competitor25 = new Competitor("John","Love",new Email("John25@gmail.com"),"John123",card);
            user25.setId("25");
            competitor25.setId("25");
            getUserDAO().save(user25);
            getCompetitorDao().save(competitor25);

            User user26 = new User("Raymond","Lasch",new Email("Raymond26@gmail.com"),"Raymond123",Role.COMPETITOR);
            Competitor competitor26 = new Competitor("Raymond","Lasch",new Email("Raymond26@gmail.com"),"Raymond123",card);
            user26.setId("26");
            competitor26.setId("26");
            getUserDAO().save(user26);
            getCompetitorDao().save(competitor26);

            User user27 = new User("Daniel","Scott",new Email("Daniel27@gmail.com"),"Daniel123",Role.COMPETITOR);
            Competitor competitor27 = new Competitor("Daniel","Scott",new Email("Daniel27@gmail.com"),"Daniel123",card);
            user27.setId("27");
            competitor27.setId("27");
            getUserDAO().save(user27);
            getCompetitorDao().save(competitor27);

            User user28 = new User("Roy","Anderson",new Email("Roy28@gmail.com"),"Roy123",Role.COMPETITOR);
            Competitor competitor28 = new Competitor("Roy","Anderson",new Email("Roy28@gmail.com"),"Roy123",card);
            user28.setId("28");
            competitor28.setId("28");
            getUserDAO().save(user28);
            getCompetitorDao().save(competitor28);

            User user29 = new User("Rodney","Lawnicki",new Email("Rodney29@gmail.com"),"Rodney123",Role.COMPETITOR);
            Competitor competitor29 = new Competitor("Rodney","Lawnicki",new Email("Rodney29@gmail.com"),"Rodney123",card);
            user29.setId("29");
            competitor29.setId("29");
            getUserDAO().save(user29);
            getCompetitorDao().save(competitor29);

            User user30 = new User("Henry","Mauro",new Email("Henry30@gmail.com"),"Henry123",Role.COMPETITOR);
            Competitor competitor30 = new Competitor("Henry","Mauro",new Email("Henry30@gmail.com"),"Henry123",card);
            user30.setId("30");
            competitor30.setId("30");
            getUserDAO().save(user30);
            getCompetitorDao().save(competitor30);

            User user31 = new User("George","Washington",new Email("George31@gmail.com"),"George123",Role.COMPETITOR);
            Competitor competitor31 = new Competitor("George","Washington",new Email("George31@gmail.com"),"George123",card);
            user31.setId("31");
            competitor31.setId("31");
            getUserDAO().save(user31);
            getCompetitorDao().save(competitor31);

            User user32 = new User("Joseph","Sinko",new Email("Joseph32@gmail.com"),"Joseph123",Role.COMPETITOR);
            Competitor competitor32 = new Competitor("Joseph","Sinko",new Email("Joseph32@gmail.com"),"Joseph123",card);
            user32.setId("32");
            competitor32.setId("32");
            getUserDAO().save(user32);
            getCompetitorDao().save(competitor32);

            User user33 = new User("Roberto","Robinson",new Email("Roberto33@gmail.com"),"Roberto123",Role.COMPETITOR);
            Competitor competitor33 = new Competitor("Roberto","Robinson",new Email("Roberto33@gmail.com"),"Roberto123",card);
            user33.setId("33");
            competitor33.setId("33");
            getUserDAO().save(user33);
            getCompetitorDao().save(competitor33);

            User user34 = new User("Gerald","Hernandez",new Email("Gerald34@gmail.com"),"Gerald123",Role.COMPETITOR);
            Competitor competitor34 = new Competitor("Gerald","Hernandez",new Email("Gerald34@gmail.com"),"Gerald123",card);
            user34.setId("34");
            competitor34.setId("34");
            getUserDAO().save(user34);
            getCompetitorDao().save(competitor34);

            User user35 = new User("Richard","Cordova",new Email("Richard35@gmail.com"),"Richard123",Role.COMPETITOR);
            Competitor competitor35 = new Competitor("Richard","Cordova",new Email("Richard35@gmail.com"),"Richard123",card);
            user35.setId("35");
            competitor35.setId("35");
            getUserDAO().save(user35);
            getCompetitorDao().save(competitor35);

            User user36 = new User("Norman","Larson",new Email("Norman36@gmail.com"),"Norman123",Role.COMPETITOR);
            Competitor competitor36 = new Competitor("Norman","Larson",new Email("Norman36@gmail.com"),"Norman123",card);
            user36.setId("36");
            competitor36.setId("36");
            getUserDAO().save(user36);
            getCompetitorDao().save(competitor36);

            User user37 = new User("Dale","Block",new Email("Dale37@gmail.com"),"Dale123",Role.COMPETITOR);
            Competitor competitor37 = new Competitor("Dale","Block",new Email("Dale37@gmail.com"),"Dale123",card);
            user37.setId("37");
            competitor37.setId("37");
            getUserDAO().save(user37);
            getCompetitorDao().save(competitor37);

            User user38 = new User("Nicholas","Sellers",new Email("Nicholas38@gmail.com"),"Nicholas123",Role.COMPETITOR);
            Competitor competitor38 = new Competitor("Nicholas","Sellers",new Email("Nicholas38@gmail.com"),"Nicholas123",card);
            user38.setId("38");
            competitor38.setId("38");
            getUserDAO().save(user38);
            getCompetitorDao().save(competitor38);

            User user39 = new User("Nathaniel","Gurley",new Email("Nathaniel39@gmail.com"),"Nathaniel123",Role.COMPETITOR);
            Competitor competitor39 = new Competitor("Nathaniel","Gurley",new Email("Nathaniel39@gmail.com"),"Nathaniel123",card);
            user39.setId("39");
            competitor39.setId("39");
            getUserDAO().save(user39);
            getCompetitorDao().save(competitor39);

            User user40 = new User("Robert","Knott",new Email("Robert40@gmail.com"),"Robert123",Role.COMPETITOR);
            Competitor competitor40 = new Competitor("Robert","Knott",new Email("Robert40@gmail.com"),"Robert123",card);
            user40.setId("40");
            competitor40.setId("40");
            getUserDAO().save(user40);
            getCompetitorDao().save(competitor40);

            User user41 = new User("Rogelio","Jones",new Email("Rogelio41@gmail.com"),"Rogelio123",Role.COMPETITOR);
            Competitor competitor41 = new Competitor("Rogelio","Jones",new Email("Rogelio41@gmail.com"),"Rogelio123",card);
            user41.setId("41");
            competitor41.setId("41");
            getUserDAO().save(user41);
            getCompetitorDao().save(competitor41);

            User user42 = new User("Norman","Davis",new Email("Norman42@gmail.com"),"Norman123",Role.COMPETITOR);
            Competitor competitor42 = new Competitor("Norman","Davis",new Email("Norman42@gmail.com"),"Norman123",card);
            user42.setId("42");
            competitor42.setId("42");
            getUserDAO().save(user42);
            getCompetitorDao().save(competitor42);

            User user43 = new User("Douglas","Pierce",new Email("Douglas43@gmail.com"),"Douglas123",Role.COMPETITOR);
            Competitor competitor43 = new Competitor("Douglas","Pierce",new Email("Douglas43@gmail.com"),"Douglas123",card);
            user43.setId("43");
            competitor43.setId("43");
            getUserDAO().save(user43);
            getCompetitorDao().save(competitor43);

            User user44 = new User("Joseph","Alvarado",new Email("Joseph44@gmail.com"),"Joseph123",Role.COMPETITOR);
            Competitor competitor44 = new Competitor("Joseph","Alvarado",new Email("Joseph44@gmail.com"),"Joseph123",card);
            user44.setId("44");
            competitor44.setId("44");
            getUserDAO().save(user44);
            getCompetitorDao().save(competitor44);

            User user45 = new User("Michael","Naval",new Email("Michael45@gmail.com"),"Michael123",Role.COMPETITOR);
            Competitor competitor45 = new Competitor("Michael","Naval",new Email("Michael45@gmail.com"),"Michael123",card);
            user45.setId("45");
            competitor45.setId("45");
            getUserDAO().save(user45);
            getCompetitorDao().save(competitor45);

            User user46 = new User("Jim","Dibartolomeo",new Email("Jim46@gmail.com"),"Jim123",Role.COMPETITOR);
            Competitor competitor46 = new Competitor("Jim","Dibartolomeo",new Email("Jim46@gmail.com"),"Jim123",card);
            user46.setId("46");
            competitor46.setId("46");
            getUserDAO().save(user46);
            getCompetitorDao().save(competitor46);

            User user47 = new User("Joseph","Zavala",new Email("Joseph47@gmail.com"),"Joseph123",Role.COMPETITOR);
            Competitor competitor47 = new Competitor("Joseph","Zavala",new Email("Joseph47@gmail.com"),"Joseph123",card);
            user47.setId("47");
            competitor47.setId("47");
            getUserDAO().save(user47);
            getCompetitorDao().save(competitor47);

            User user48 = new User("Eugene","Morris",new Email("Eugene48@gmail.com"),"Eugene123",Role.COMPETITOR);
            Competitor competitor48 = new Competitor("Eugene","Morris",new Email("Eugene48@gmail.com"),"Eugene123",card);
            user48.setId("48");
            competitor48.setId("48");
            getUserDAO().save(user48);
            getCompetitorDao().save(competitor48);

            User user49 = new User("Zachary","Halls",new Email("Zachary49@gmail.com"),"Zachary123",Role.COMPETITOR);
            Competitor competitor49 = new Competitor("Zachary","Halls",new Email("Zachary49@gmail.com"),"Zachary123",card);
            user49.setId("49");
            competitor49.setId("49");
            getUserDAO().save(user49);
            getCompetitorDao().save(competitor49);


            //Creating 10 Organizers
            User user50 = new User("Robert","Thurman",new Email("Robert51@gmail.com"),"Robert123",Role.ORGANIZER);
            Organizer organizer0 = new Organizer("Robert","Thurman",new Email("Robert51@gmail.com"),"Robert123","PATNEIO");
            user50.setId("50");
            organizer0.setId("50");
            getUserDAO().save(user50);
            getOrganizerDAO().save(organizer0);

            User user51 = new User("Kenneth","Haggerty",new Email("Kenneth52@gmail.com"),"Kenneth123",Role.ORGANIZER);
            Organizer organizer1 = new Organizer("Kenneth","Haggerty",new Email("Kenneth52@gmail.com"),"Kenneth123","IWANNINWN");
            user51.setId("51");
            organizer1.setId("51");
            getUserDAO().save(user51);
            getOrganizerDAO().save(organizer1);

            User user52 = new User("Tom","Ogletree",new Email("Tom53@gmail.com"),"Tom123",Role.ORGANIZER);
            Organizer organizer2 = new Organizer("Tom","Ogletree",new Email("Tom53@gmail.com"),"Tom123","PATNEIO");
            user52.setId("52");
            organizer2.setId("52");
            getUserDAO().save(user52);
            getOrganizerDAO().save(organizer2);

            User user53 = new User("Patrick","Lang",new Email("Patrick54@gmail.com"),"Patrick123",Role.ORGANIZER);
            Organizer organizer3 = new Organizer("Patrick","Lang",new Email("Patrick54@gmail.com"),"Patrick123","AUEB");
            user53.setId("53");
            organizer3.setId("53");
            getUserDAO().save(user53);
            getOrganizerDAO().save(organizer3);

            User user54 = new User("Oliver","Briggs",new Email("Oliver55@gmail.com"),"Oliver123",Role.ORGANIZER);
            Organizer organizer4 = new Organizer("Oliver","Briggs",new Email("Oliver55@gmail.com"),"Oliver123","PATNEIO");
            user54.setId("54");
            organizer4.setId("54");
            getUserDAO().save(user54);
            getOrganizerDAO().save(organizer4);

            User user55 = new User("Douglas","Jones",new Email("Douglas56@gmail.com"),"Douglas123",Role.ORGANIZER);
            Organizer organizer5 = new Organizer("Douglas","Jones",new Email("Douglas56@gmail.com"),"Douglas123","ARISTOTELEIO");
            user55.setId("55");
            organizer5.setId("55");
            getUserDAO().save(user55);
            getOrganizerDAO().save(organizer5);

            User user56 = new User("James","Walton",new Email("James57@gmail.com"),"James123",Role.ORGANIZER);
            Organizer organizer6 = new Organizer("James","Walton",new Email("James57@gmail.com"),"James123","EKPA");
            user56.setId("56");
            organizer6.setId("56");
            getUserDAO().save(user56);
            getOrganizerDAO().save(organizer6);

            User user57 = new User("Wesley","Bonilla",new Email("Wesley58@gmail.com"),"Wesley123",Role.ORGANIZER);
            Organizer organizer7 = new Organizer("Wesley","Bonilla",new Email("Wesley58@gmail.com"),"Wesley123","AUEB");
            user57.setId("57");
            organizer7.setId("57");
            getUserDAO().save(user57);
            getOrganizerDAO().save(organizer7);

            User user58 = new User("Brian","Heslop",new Email("Brian59@gmail.com"),"Brian123",Role.ORGANIZER);
            Organizer organizer8 = new Organizer("Brian","Heslop",new Email("Brian59@gmail.com"),"Brian123","IWANNINWN");
            user58.setId("58");
            organizer8.setId("58");
            getUserDAO().save(user58);
            getOrganizerDAO().save(organizer8);

            User user59 = new User("Jesse","Hereford",new Email("Jesse60@gmail.com"),"Jesse123",Role.ORGANIZER);
            Organizer organizer9 = new Organizer("Jesse","Hereford",new Email("Jesse60@gmail.com"),"Jesse123","IWANNINWN");
            user59.setId("59");
            organizer9.setId("59");
            getUserDAO().save(user59);
            getOrganizerDAO().save(organizer9);

            //Create 5 Sponsors
            Card sponsorCard = new Card();
            sponsorCard.setBalance(2500.0);

            User user60 = new User("Alberto","Greene",new Email("Alberto61@gmail.com"),"Alberto123",Role.SPONSOR);
            Sponsor sponsor0 = new Sponsor("Alberto","Greene",new Email("Alberto61@gmail.com"),"Alberto123","NIKE",sponsorCard);
            user60.setId("60");
            sponsor0.setId("60");
            getUserDAO().save(user60);
            getSponsorDAO().save(sponsor0);

            User user61 = new User("Dwight","Raymond",new Email("Dwight62@gmail.com"),"Dwight123",Role.SPONSOR);
            Sponsor sponsor1 = new Sponsor("Dwight","Raymond",new Email("Dwight62@gmail.com"),"Dwight123","NIKE",sponsorCard);
            user61.setId("61");
            sponsor1.setId("61");
            getUserDAO().save(user61);
            getSponsorDAO().save(sponsor1);

            User user62 = new User("Glenn","Starcher",new Email("Glenn63@gmail.com"),"Glenn123",Role.SPONSOR);
            Sponsor sponsor2 = new Sponsor("Glenn","Starcher",new Email("Glenn63@gmail.com"),"Glenn123","ADIDAS",sponsorCard);
            user62.setId("62");
            sponsor2.setId("62");
            getUserDAO().save(user62);
            getSponsorDAO().save(sponsor2);

            User user63 = new User("Israel","Hall",new Email("Israel64@gmail.com"),"Israel123",Role.SPONSOR);
            Sponsor sponsor3 = new Sponsor("Israel","Hall",new Email("Israel64@gmail.com"),"Israel123","MIZUNO",sponsorCard);
            user63.setId("63");
            sponsor3.setId("63");
            getUserDAO().save(user63);
            getSponsorDAO().save(sponsor3);

            User user64 = new User("Robert","Collins",new Email("Robert65@gmail.com"),"Robert123",Role.SPONSOR);
            Sponsor sponsor4 = new Sponsor("Robert","Collins",new Email("Robert65@gmail.com"),"Robert123","GT",sponsorCard);
            user64.setId("64");
            sponsor4.setId("64");
            getUserDAO().save(user64);
            getSponsorDAO().save(sponsor4);


            //Create 3 Referees
            User user65 = new User("Rick","Hoffman",new Email("Rick66@gmail.com"),"Rick123",Role.REFEREE);
            Referee referee1 = new Referee("Rick","Hoffman",new Email("Rick66@gmail.com"),"Rick123");
            user65.setId("65");
            referee1.setId("65");
            getUserDAO().save(user65);
            getRefereeDAO().save(referee1);

            User user66 = new User("Daniel","Sample",new Email("Daniel67@gmail.com"),"Daniel123",Role.REFEREE);
            Referee referee2 = new Referee("Daniel","Sample",new Email("Daniel67@gmail.com"),"Daniel123");
            user66.setId("66");
            referee2.setId("66");
            getUserDAO().save(user66);
            getRefereeDAO().save(referee2);

            User user67 = new User("Raymond","Hernandez",new Email("Hernandez68@gmail.com"),"Raymond123",Role.REFEREE);
            Referee referee3 = new Referee("Raymond","Hernandez",new Email("Hernandez68@gmail.com"),"Raymond123");
            user67.setId("67");
            referee3.setId("67");
            getUserDAO().save(user67);
            getRefereeDAO().save(referee3);


            //Create 10 Races
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateString;
            String dueDateString;
            Date date;
            Date dueDate;
            Participation participation;

            dateString = "10-08-2022";
            dueDateString = "01-08-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race0 = new Race("downhill 2022",new Place("Thessalia", "Olympos"),date,RaceType.OFFROAD,35,dueDate,organizer1,new Money(17),new Money(714));
            race0.setId("0");
            race0.setReferee(referee1);
            participation = new Participation(competitor0,race0);
            participation.setId(0);
            race0.addParticipant(participation);
            participation = new Participation(competitor1,race0);
            participation.setId(1);
            race0.addParticipant(participation);
            participation = new Participation(competitor2,race0);
            participation.setId(2);
            race0.addParticipant(participation);
            participation = new Participation(competitor3,race0);
            participation.setId(3);
            race0.addParticipant(participation);
            participation = new Participation(competitor4,race0);
            participation.setId(4);
            race0.addParticipant(participation);
            participation = new Participation(competitor5,race0);
            participation.setId(5);
            race0.addParticipant(participation);
            participation = new Participation(competitor6,race0);
            participation.setId(6);
            race0.addParticipant(participation);
            participation = new Participation(competitor7,race0);
            participation.setId(7);
            race0.addParticipant(participation);
            participation = new Participation(competitor8,race0);
            participation.setId(8);
            race0.addParticipant(participation);
            participation = new Participation(competitor9,race0);
            participation.setId(9);
            race0.addParticipant(participation);
            participation = new Participation(competitor10,race0);
            participation.setId(10);
            race0.addParticipant(participation);
            participation = new Participation(competitor11,race0);
            participation.setId(11);
            race0.addParticipant(participation);
            participation = new Participation(competitor12,race0);
            participation.setId(12);
            race0.addParticipant(participation);
            participation = new Participation(competitor13,race0);
            participation.setId(13);
            race0.addParticipant(participation);
            participation = new Participation(competitor14,race0);
            participation.setId(14);
            race0.addParticipant(participation);
            participation = new Participation(competitor15,race0);
            participation.setId(15);
            race0.addParticipant(participation);
            participation = new Participation(competitor16,race0);
            participation.setId(16);
            race0.addParticipant(participation);
            participation = new Participation(competitor17,race0);
            participation.setId(17);
            race0.addParticipant(participation);
            participation = new Participation(competitor18,race0);
            participation.setId(18);
            race0.addParticipant(participation);
            participation = new Participation(competitor19,race0);
            participation.setId(19);
            race0.addParticipant(participation);
            race0.addSponsorshipApplication(new SponsorshipApplication(221,sponsor0));
            race0.addSponsorshipApplication(new SponsorshipApplication(287,sponsor1));
            getRaceDao().save(race0);

            dateString = "15-08-2022";
            dueDateString = "05-08-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race1 = new Race("high mountains",new Place("Athens", "Parnitha"),date,RaceType.OFFROAD,79,dueDate,organizer1,new Money(22),new Money(954));
            race1.setId("1");
            race1.setReferee(referee1);
            participation = new Participation(competitor0,race1);
            participation.setId(0);
            race1.addParticipant(participation);
            participation = new Participation(competitor1,race1);
            participation.setId(1);
            race1.addParticipant(participation);
            participation = new Participation(competitor2,race1);
            participation.setId(2);
            race1.addParticipant(participation);
            participation = new Participation(competitor3,race1);
            participation.setId(3);
            race1.addParticipant(participation);
            participation = new Participation(competitor4,race1);
            participation.setId(4);
            race1.addParticipant(participation);
            participation = new Participation(competitor5,race1);
            participation.setId(5);
            race1.addParticipant(participation);
            participation = new Participation(competitor6,race1);
            participation.setId(6);
            race1.addParticipant(participation);
            participation = new Participation(competitor7,race1);
            participation.setId(7);
            race1.addParticipant(participation);
            participation = new Participation(competitor8,race1);
            participation.setId(8);
            race1.addParticipant(participation);
            participation = new Participation(competitor9,race1);
            participation.setId(9);
            race1.addParticipant(participation);
            participation = new Participation(competitor10,race1);
            participation.setId(10);
            race1.addParticipant(participation);
            participation = new Participation(competitor11,race1);
            participation.setId(11);
            race1.addParticipant(participation);
            participation = new Participation(competitor12,race1);
            participation.setId(12);
            race1.addParticipant(participation);
            participation = new Participation(competitor13,race1);
            participation.setId(13);
            race1.addParticipant(participation);
            participation = new Participation(competitor14,race1);
            participation.setId(14);
            race1.addParticipant(participation);
            participation = new Participation(competitor15,race1);
            participation.setId(15);
            race1.addParticipant(participation);
            participation = new Participation(competitor16,race1);
            participation.setId(16);
            race1.addParticipant(participation);
            participation = new Participation(competitor17,race1);
            participation.setId(17);
            race1.addParticipant(participation);
            participation = new Participation(competitor18,race1);
            participation.setId(18);
            race1.addParticipant(participation);
            participation = new Participation(competitor19,race1);
            participation.setId(19);
            race1.addParticipant(participation);
            race1.addSponsorshipApplication(new SponsorshipApplication(317,sponsor0));
            race1.addSponsorshipApplication(new SponsorshipApplication(204,sponsor1));
            race1.setReferee(referee1);
            getRaceDao().save(race1);

            dateString = "20-08-2022";
            dueDateString = "29-07-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race2 = new Race("no limits",new Place("Crete", "Psiloreiths"),date,RaceType.OFFROAD,66,dueDate,organizer1,new Money(16),new Money(1012));
            race2.setId("2");
            race2.setReferee(referee1);
            participation = new Participation(competitor0,race2);
            participation.setId(0);
            race2.addParticipant(participation);
            participation = new Participation(competitor1,race2);
            participation.setId(1);
            race2.addParticipant(participation);
            participation = new Participation(competitor2,race2);
            participation.setId(2);
            race2.addParticipant(participation);
            participation = new Participation(competitor3,race2);
            participation.setId(3);
            race2.addParticipant(participation);
            participation = new Participation(competitor4,race2);
            participation.setId(4);
            race2.addParticipant(participation);
            participation = new Participation(competitor5,race2);
            participation.setId(5);
            race2.addParticipant(participation);
            participation = new Participation(competitor6,race2);
            participation.setId(6);
            race2.addParticipant(participation);
            participation = new Participation(competitor7,race2);
            participation.setId(7);
            race2.addParticipant(participation);
            participation = new Participation(competitor8,race2);
            participation.setId(8);
            race2.addParticipant(participation);
            participation = new Participation(competitor9,race2);
            participation.setId(9);
            race2.addParticipant(participation);
            participation = new Participation(competitor10,race2);
            participation.setId(10);
            race2.addParticipant(participation);
            participation = new Participation(competitor11,race2);
            participation.setId(11);
            race2.addParticipant(participation);
            participation = new Participation(competitor12,race2);
            participation.setId(12);
            race2.addParticipant(participation);
            participation = new Participation(competitor13,race2);
            participation.setId(13);
            race2.addParticipant(participation);
            participation = new Participation(competitor14,race2);
            participation.setId(14);
            race2.addParticipant(participation);
            participation = new Participation(competitor15,race2);
            participation.setId(15);
            race2.addParticipant(participation);
            participation = new Participation(competitor16,race2);
            participation.setId(16);
            race2.addParticipant(participation);
            participation = new Participation(competitor17,race2);
            participation.setId(17);
            race2.addParticipant(participation);
            participation = new Participation(competitor18,race2);
            participation.setId(18);
            race2.addParticipant(participation);
            participation = new Participation(competitor19,race2);
            participation.setId(19);
            race2.addParticipant(participation);
            race2.addSponsorshipApplication(new SponsorshipApplication(239,sponsor0));
            race2.addSponsorshipApplication(new SponsorshipApplication(268,sponsor1));
            race2.setReferee(referee1);
            getRaceDao().save(race2);

            dateString = "20-08-2022";
            dueDateString = "03-08-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race3 = new Race("above the sky",new Place("Fokida", "Gkiwna"),date,RaceType.OFFROAD,66,dueDate,organizer1,new Money(19),new Money(1077));
            race3.setId("3");
            race3.setReferee(referee1);
            participation = new Participation(competitor0,race3);
            participation.setId(0);
            race3.addParticipant(participation);
            participation = new Participation(competitor1,race3);
            participation.setId(1);
            race3.addParticipant(participation);
            participation = new Participation(competitor2,race3);
            participation.setId(2);
            race3.addParticipant(participation);
            participation = new Participation(competitor3,race3);
            participation.setId(3);
            race3.addParticipant(participation);
            participation = new Participation(competitor4,race3);
            participation.setId(4);
            race3.addParticipant(participation);
            participation = new Participation(competitor5,race3);
            participation.setId(5);
            race3.addParticipant(participation);
            participation = new Participation(competitor6,race3);
            participation.setId(6);
            race3.addParticipant(participation);
            participation = new Participation(competitor7,race3);
            participation.setId(7);
            race3.addParticipant(participation);
            participation = new Participation(competitor8,race3);
            participation.setId(8);
            race3.addParticipant(participation);
            participation = new Participation(competitor9,race3);
            participation.setId(9);
            race3.addParticipant(participation);
            participation = new Participation(competitor10,race3);
            participation.setId(10);
            race3.addParticipant(participation);
            participation = new Participation(competitor11,race3);
            participation.setId(11);
            race3.addParticipant(participation);
            participation = new Participation(competitor12,race3);
            participation.setId(12);
            race3.addParticipant(participation);
            participation = new Participation(competitor13,race3);
            participation.setId(13);
            race3.addParticipant(participation);
            participation = new Participation(competitor14,race3);
            participation.setId(14);
            race3.addParticipant(participation);
            participation = new Participation(competitor15,race3);
            participation.setId(15);
            race3.addParticipant(participation);
            participation = new Participation(competitor16,race3);
            participation.setId(16);
            race3.addParticipant(participation);
            participation = new Participation(competitor17,race3);
            participation.setId(17);
            race3.addParticipant(participation);
            participation = new Participation(competitor18,race3);
            participation.setId(18);
            race3.addParticipant(participation);
            participation = new Participation(competitor19,race3);
            participation.setId(19);
            race3.addParticipant(participation);
            race3.addSponsorshipApplication(new SponsorshipApplication(272,sponsor0));
            race3.addSponsorshipApplication(new SponsorshipApplication(263,sponsor1));
            race3.setReferee(referee1);
            getRaceDao().save(race3);

            dateString = "16-08-2022";
            dueDateString = "04-08-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race4 = new Race("on the rocks",new Place("Evoia", "Dirfys"),date,RaceType.OFFROAD,40,dueDate,organizer2,new Money(18),new Money(769));
            race4.setId("4");
            race4.setReferee(referee2);
            participation = new Participation(competitor0,race4);
            participation.setId(0);
            race4.addParticipant(participation);
            participation = new Participation(competitor1,race4);
            participation.setId(1);
            race4.addParticipant(participation);
            participation = new Participation(competitor2,race4);
            participation.setId(2);
            race4.addParticipant(participation);
            participation = new Participation(competitor3,race4);
            participation.setId(3);
            race4.addParticipant(participation);
            participation = new Participation(competitor4,race4);
            participation.setId(4);
            race4.addParticipant(participation);
            participation = new Participation(competitor5,race4);
            participation.setId(5);
            race4.addParticipant(participation);
            participation = new Participation(competitor6,race4);
            participation.setId(6);
            race4.addParticipant(participation);
            participation = new Participation(competitor7,race4);
            participation.setId(7);
            race4.addParticipant(participation);
            participation = new Participation(competitor8,race4);
            participation.setId(8);
            race4.addParticipant(participation);
            participation = new Participation(competitor9,race4);
            participation.setId(9);
            race4.addParticipant(participation);
            participation = new Participation(competitor10,race4);
            participation.setId(10);
            race4.addParticipant(participation);
            participation = new Participation(competitor11,race4);
            participation.setId(11);
            race4.addParticipant(participation);
            participation = new Participation(competitor12,race4);
            participation.setId(12);
            race4.addParticipant(participation);
            participation = new Participation(competitor13,race4);
            participation.setId(13);
            race4.addParticipant(participation);
            participation = new Participation(competitor14,race4);
            participation.setId(14);
            race4.addParticipant(participation);
            participation = new Participation(competitor15,race4);
            participation.setId(15);
            race4.addParticipant(participation);
            participation = new Participation(competitor16,race4);
            participation.setId(16);
            race4.addParticipant(participation);
            participation = new Participation(competitor17,race4);
            participation.setId(17);
            race4.addParticipant(participation);
            participation = new Participation(competitor18,race4);
            participation.setId(18);
            race4.addParticipant(participation);
            participation = new Participation(competitor19,race4);
            participation.setId(19);
            race4.addParticipant(participation);
            race4.addSponsorshipApplication(new SponsorshipApplication(234,sponsor0));
            race4.addSponsorshipApplication(new SponsorshipApplication(257,sponsor1));
            race4.setReferee(referee1);
            getRaceDao().save(race4);

            dateString = "10-07-2022";
            dueDateString = "29-06-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race5 = new Race("street lights",new Place("Athens", "Vouliagmeni"),date,RaceType.STREET,50,dueDate,organizer2,new Money(11),new Money(870));
            race5.setId("5");
            race5.setReferee(referee2);
            participation = new Participation(competitor0,race5);
            participation.setId(0);
            race5.addParticipant(participation);
            participation = new Participation(competitor1,race5);
            participation.setId(1);
            race5.addParticipant(participation);
            participation = new Participation(competitor2,race5);
            participation.setId(2);
            race5.addParticipant(participation);
            participation = new Participation(competitor3,race5);
            participation.setId(3);
            race5.addParticipant(participation);
            participation = new Participation(competitor4,race5);
            participation.setId(4);
            race5.addParticipant(participation);
            participation = new Participation(competitor5,race5);
            participation.setId(5);
            race5.addParticipant(participation);
            participation = new Participation(competitor6,race5);
            participation.setId(6);
            race5.addParticipant(participation);
            participation = new Participation(competitor7,race5);
            participation.setId(7);
            race5.addParticipant(participation);
            participation = new Participation(competitor8,race5);
            participation.setId(8);
            race5.addParticipant(participation);
            participation = new Participation(competitor9,race5);
            participation.setId(9);
            race5.addParticipant(participation);
            participation = new Participation(competitor10,race5);
            participation.setId(10);
            race5.addParticipant(participation);
            participation = new Participation(competitor11,race5);
            participation.setId(11);
            race5.addParticipant(participation);
            participation = new Participation(competitor12,race5);
            participation.setId(12);
            race5.addParticipant(participation);
            participation = new Participation(competitor13,race5);
            participation.setId(13);
            race5.addParticipant(participation);
            participation = new Participation(competitor14,race5);
            participation.setId(14);
            race5.addParticipant(participation);
            participation = new Participation(competitor15,race5);
            participation.setId(15);
            race5.addParticipant(participation);
            participation = new Participation(competitor16,race5);
            participation.setId(16);
            race5.addParticipant(participation);
            participation = new Participation(competitor17,race5);
            participation.setId(17);
            race5.addParticipant(participation);
            participation = new Participation(competitor18,race5);
            participation.setId(18);
            race5.addParticipant(participation);
            participation = new Participation(competitor19,race5);
            participation.setId(19);
            race5.addParticipant(participation);
            race5.addSponsorshipApplication(new SponsorshipApplication(269,sponsor0));
            race5.addSponsorshipApplication(new SponsorshipApplication(274,sponsor1));
            race5.setReferee(referee1);
            getRaceDao().save(race5);

            dateString = "15-07-2022";
            dueDateString = "03-06-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race6 = new Race("infinitive street",new Place("Athens", "Malakasa"),date,RaceType.STREET,57,dueDate,organizer2,new Money(16),new Money(1106));
            race6.setId("6");
            race6.setReferee(referee2);
            participation = new Participation(competitor0,race6);
            participation.setId(0);
            race6.addParticipant(participation);
            participation = new Participation(competitor1,race6);
            participation.setId(1);
            race6.addParticipant(participation);
            participation = new Participation(competitor2,race6);
            participation.setId(2);
            race6.addParticipant(participation);
            participation = new Participation(competitor3,race6);
            participation.setId(3);
            race6.addParticipant(participation);
            participation = new Participation(competitor4,race6);
            participation.setId(4);
            race6.addParticipant(participation);
            participation = new Participation(competitor5,race6);
            participation.setId(5);
            race6.addParticipant(participation);
            participation = new Participation(competitor6,race6);
            participation.setId(6);
            race6.addParticipant(participation);
            participation = new Participation(competitor7,race6);
            participation.setId(7);
            race6.addParticipant(participation);
            participation = new Participation(competitor8,race6);
            participation.setId(8);
            race6.addParticipant(participation);
            participation = new Participation(competitor9,race6);
            participation.setId(9);
            race6.addParticipant(participation);
            participation = new Participation(competitor10,race6);
            participation.setId(10);
            race6.addParticipant(participation);
            participation = new Participation(competitor11,race6);
            participation.setId(11);
            race6.addParticipant(participation);
            participation = new Participation(competitor12,race6);
            participation.setId(12);
            race6.addParticipant(participation);
            participation = new Participation(competitor13,race6);
            participation.setId(13);
            race6.addParticipant(participation);
            participation = new Participation(competitor14,race6);
            participation.setId(14);
            race6.addParticipant(participation);
            participation = new Participation(competitor15,race6);
            participation.setId(15);
            race6.addParticipant(participation);
            participation = new Participation(competitor16,race6);
            participation.setId(16);
            race6.addParticipant(participation);
            participation = new Participation(competitor17,race6);
            participation.setId(17);
            race6.addParticipant(participation);
            participation = new Participation(competitor18,race6);
            participation.setId(18);
            race6.addParticipant(participation);
            participation = new Participation(competitor19,race6);
            participation.setId(19);
            race6.addParticipant(participation);
            race6.addSponsorshipApplication(new SponsorshipApplication(329,sponsor0));
            race6.addSponsorshipApplication(new SponsorshipApplication(242,sponsor1));
            race6.setReferee(referee1);
            getRaceDao().save(race6);

            dateString = "20-07-2022";
            dueDateString = "02-07-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race7 = new Race("tour of Athens",new Place("Athens", "Monasthraki"),date,RaceType.STREET,45,dueDate,organizer3,new Money(19),new Money(1374));
            race7.setId("7");
            race7.setReferee(referee3);
            participation = new Participation(competitor0,race7);
            participation.setId(0);
            race7.addParticipant(participation);
            participation = new Participation(competitor1,race7);
            participation.setId(1);
            race7.addParticipant(participation);
            participation = new Participation(competitor2,race7);
            participation.setId(2);
            race7.addParticipant(participation);
            participation = new Participation(competitor3,race7);
            participation.setId(3);
            race7.addParticipant(participation);
            participation = new Participation(competitor4,race7);
            participation.setId(4);
            race7.addParticipant(participation);
            participation = new Participation(competitor5,race7);
            participation.setId(5);
            race7.addParticipant(participation);
            participation = new Participation(competitor6,race7);
            participation.setId(6);
            race7.addParticipant(participation);
            participation = new Participation(competitor7,race7);
            participation.setId(7);
            race7.addParticipant(participation);
            participation = new Participation(competitor8,race7);
            participation.setId(8);
            race7.addParticipant(participation);
            participation = new Participation(competitor9,race7);
            participation.setId(9);
            race7.addParticipant(participation);
            participation = new Participation(competitor10,race7);
            participation.setId(10);
            race7.addParticipant(participation);
            participation = new Participation(competitor11,race7);
            participation.setId(11);
            race7.addParticipant(participation);
            participation = new Participation(competitor12,race7);
            participation.setId(12);
            race7.addParticipant(participation);
            participation = new Participation(competitor13,race7);
            participation.setId(13);
            race7.addParticipant(participation);
            participation = new Participation(competitor14,race7);
            participation.setId(14);
            race7.addParticipant(participation);
            participation = new Participation(competitor15,race7);
            participation.setId(15);
            race7.addParticipant(participation);
            participation = new Participation(competitor16,race7);
            participation.setId(16);
            race7.addParticipant(participation);
            participation = new Participation(competitor17,race7);
            participation.setId(17);
            race7.addParticipant(participation);
            participation = new Participation(competitor18,race7);
            participation.setId(18);
            race7.addParticipant(participation);
            participation = new Participation(competitor19,race7);
            participation.setId(19);
            race7.addParticipant(participation);
            race7.addSponsorshipApplication(new SponsorshipApplication(226,sponsor0));
            race7.addSponsorshipApplication(new SponsorshipApplication(218,sponsor1));
            race7.setReferee(referee1);
            getRaceDao().save(race7);

            dateString = "30-07-2022";
            dueDateString = "15-07-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race8 = new Race("fast biking",new Place("Ioannina", "Molos"),date,RaceType.STREET,46,dueDate,organizer3,new Money(19),new Money(721));
            race8.setId("8");
            race8.setReferee(referee3);
            participation = new Participation(competitor0,race8);
            participation.setId(0);
            race8.addParticipant(participation);
            participation = new Participation(competitor1,race8);
            participation.setId(1);
            race8.addParticipant(participation);
            participation = new Participation(competitor2,race8);
            participation.setId(2);
            race8.addParticipant(participation);
            participation = new Participation(competitor3,race8);
            participation.setId(3);
            race8.addParticipant(participation);
            participation = new Participation(competitor4,race8);
            participation.setId(4);
            race8.addParticipant(participation);
            participation = new Participation(competitor5,race8);
            participation.setId(5);
            race8.addParticipant(participation);
            participation = new Participation(competitor6,race8);
            participation.setId(6);
            race8.addParticipant(participation);
            participation = new Participation(competitor7,race8);
            participation.setId(7);
            race8.addParticipant(participation);
            participation = new Participation(competitor8,race8);
            participation.setId(8);
            race8.addParticipant(participation);
            participation = new Participation(competitor9,race8);
            participation.setId(9);
            race8.addParticipant(participation);
            participation = new Participation(competitor10,race8);
            participation.setId(10);
            race8.addParticipant(participation);
            participation = new Participation(competitor11,race8);
            participation.setId(11);
            race8.addParticipant(participation);
            participation = new Participation(competitor12,race8);
            participation.setId(12);
            race8.addParticipant(participation);
            participation = new Participation(competitor13,race8);
            participation.setId(13);
            race8.addParticipant(participation);
            participation = new Participation(competitor14,race8);
            participation.setId(14);
            race8.addParticipant(participation);
            participation = new Participation(competitor15,race8);
            participation.setId(15);
            race8.addParticipant(participation);
            participation = new Participation(competitor16,race8);
            participation.setId(16);
            race8.addParticipant(participation);
            participation = new Participation(competitor17,race8);
            participation.setId(17);
            race8.addParticipant(participation);
            participation = new Participation(competitor18,race8);
            participation.setId(18);
            race8.addParticipant(participation);
            participation = new Participation(competitor19,race8);
            participation.setId(19);
            race8.addParticipant(participation);
            race8.addSponsorshipApplication(new SponsorshipApplication(311,sponsor0));
            race8.addSponsorshipApplication(new SponsorshipApplication(277,sponsor1));
            race8.setReferee(referee1);
            getRaceDao().save(race8);

            dateString = "25-07-2022";
            dueDateString = "04-07-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race9 = new Race("road warriors",new Place("Thessaloniki", "Kalamaria"),date,RaceType.STREET,55,dueDate,organizer3,new Money(19),new Money(1239));
            race9.setId("9");
            race9.setReferee(referee3);
            participation = new Participation(competitor0,race9);
            participation.setId(0);
            race9.addParticipant(participation);
            participation = new Participation(competitor1,race9);
            participation.setId(1);
            race9.addParticipant(participation);
            participation = new Participation(competitor2,race9);
            participation.setId(2);
            race9.addParticipant(participation);
            participation = new Participation(competitor3,race9);
            participation.setId(3);
            race9.addParticipant(participation);
            participation = new Participation(competitor4,race9);
            participation.setId(4);
            race9.addParticipant(participation);
            participation = new Participation(competitor5,race9);
            participation.setId(5);
            race9.addParticipant(participation);
            participation = new Participation(competitor6,race9);
            participation.setId(6);
            race9.addParticipant(participation);
            participation = new Participation(competitor7,race9);
            participation.setId(7);
            race9.addParticipant(participation);
            participation = new Participation(competitor8,race9);
            participation.setId(8);
            race9.addParticipant(participation);
            participation = new Participation(competitor9,race9);
            participation.setId(9);
            race9.addParticipant(participation);
            participation = new Participation(competitor10,race9);
            participation.setId(10);
            race9.addParticipant(participation);
            participation = new Participation(competitor11,race9);
            participation.setId(11);
            race9.addParticipant(participation);
            participation = new Participation(competitor12,race9);
            participation.setId(12);
            race9.addParticipant(participation);
            participation = new Participation(competitor13,race9);
            participation.setId(13);
            race9.addParticipant(participation);
            participation = new Participation(competitor14,race9);
            participation.setId(14);
            race9.addParticipant(participation);
            participation = new Participation(competitor15,race9);
            participation.setId(15);
            race9.addParticipant(participation);
            participation = new Participation(competitor16,race9);
            participation.setId(16);
            race9.addParticipant(participation);
            participation = new Participation(competitor17,race9);
            participation.setId(17);
            race9.addParticipant(participation);
            participation = new Participation(competitor18,race9);
            participation.setId(18);
            race9.addParticipant(participation);
            participation = new Participation(competitor19,race9);
            participation.setId(19);
            race9.addParticipant(participation);
            race9.addSponsorshipApplication(new SponsorshipApplication(263,sponsor0));
            race9.addSponsorshipApplication(new SponsorshipApplication(216,sponsor1));
            race9.setReferee(referee1);
            getRaceDao().save(race9);



            //CREATE A DUMMY RACE TO SHOW OFF SPECIFIC FUNCTIONALITY OF THE APPLICATION --- REFEREE + HISTORY

            dateString = "24-05-2022";
            dueDateString = "10-05-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);

            Race dummy_race = new Race("dummy_race",new Place("Dummy", "Place"),date,RaceType.STREET,55,dueDate,organizer5,new Money(20),new Money(40));
            participation = new Participation(competitor0,dummy_race);
            participation.setId(0);
            dummy_race.addParticipant(participation);
            participation = new Participation(competitor1,dummy_race);
            participation.setId(1);
            dummy_race.addParticipant(participation);
            participation = new Participation(competitor2,dummy_race);
            participation.setId(2);
            dummy_race.addParticipant(participation);
            participation = new Participation(competitor3,dummy_race);
            participation.setId(3);
            dummy_race.addParticipant(participation);
            participation = new Participation(competitor4,dummy_race);
            participation.setId(4);
            dummy_race.addParticipant(participation);
            participation = new Participation(competitor5,dummy_race);
            participation.setId(5);
            dummy_race.addParticipant(participation);

            dummy_race.setId("dummy_race");
            dummy_race.setReferee(referee1);
            getRaceDao().save(dummy_race);




            //DATA IN WHICH TESTS ARE WORKING PROPERLY

            /*

            //Create 4 Competitors
            Card card;

            card = new Card();
            card.setBalance(100.0);
            Competitor competitor1 = new Competitor("tolis","kapetis",new Email("p3190071@aueb.gr"),"tolis123",card);
            User user1 = new User("tolis","kapetis",new Email("p3190071@aueb.gr"),"tolis123", Role.COMPETITOR);
            user1.setId("competitor_tolis");
            competitor1.setId("competitor_tolis");
            getUserDAO().save(user1);
            getCompetitorDao().save(competitor1);


            card = new Card();
            card.setBalance(200.0);
            Competitor competitor2 = new Competitor("nikos","nikolopoulos",new Email("p3190146@aueb.gr"),"nikos123",card);

            User user2 = new User("nikos","nikolopoulos",new Email("p3190146@aueb.gr"),"nikos123", Role.COMPETITOR);
            user2.setId("competitor_nikos");
            competitor2.setId("competitor_nikos");
            getUserDAO().save(user2);
            getCompetitorDao().save(competitor2);


            card = new Card();
            card.setBalance(150.0);
            Competitor competitor3 = new Competitor("stathis","parasidhs",new Email("p3190163@aueb.gr"),"stathis123",card);
            User user3 = new User("stathis","parasidhs",new Email("p3190163@aueb.gr"),"stathis123", Role.COMPETITOR);
            user3.setId("competitor_stathis");
            competitor3.setId("competitor_stathis");
            getUserDAO().save(user3);
            getCompetitorDao().save(competitor3);


            card = new Card();
            card.setBalance(2.0);
            Competitor competitor4 = new Competitor("dummy","dummy",new Email("dummy@gmail.com"),"dummy123",card);
            User user4 = new User("dummy","dummy",new Email("dummy@gmail.com"),"dummy123", Role.COMPETITOR);
            user4.setId("competitor_dummy");
            competitor4.setId("competitor_dummy");
            getUserDAO().save(user4);
            getCompetitorDao().save(competitor4);



            //Create 2 organizers
            Organizer organizer1 = new Organizer("org0","org0",new Email("org0@gmail.com"),"org0","Team01");
            User user5 = new User("org0","org0",new Email("org0@gmail.com"),"org0",Role.ORGANIZER);
            user5.setId("org0");
            organizer1.setId("org0");
            getUserDAO().save(user5);
            getOrganizerDAO().save(organizer1);

            Organizer organizer2 = new Organizer("org1","org1",new Email("org1@gmail.com"),"org1","Team02");
            User user6 = new User("org1","org1",new Email("org1@gmail.com"),"org1",Role.ORGANIZER);
            user6.setId("org1");
            organizer2.setId("org1");
            getUserDAO().save(user6);
            getOrganizerDAO().save(organizer2);


            //create 2 referees
            Referee referee1 = new Referee("ref0","ref0",new Email("ref0@gmail.com"),"ref0");
            User user7 = new User("ref0","ref0",new Email("ref0@gmail.com"),"ref0",Role.REFEREE);
            user7.setId("ref0");
            referee1.setId("ref0");
            getUserDAO().save(user7);
            getRefereeDAO().save(referee1);

            Referee referee2 = new Referee("ref1","ref1",new Email("ref1@gmail.com"),"ref1");
            User user8 = new User("ref1","ref1",new Email("ref1@gmail.com"),"ref1",Role.REFEREE);
            user8.setId("ref1");
            referee2.setId("ref1");
            getUserDAO().save(user8);
            getRefereeDAO().save(referee2);

            //create 1 sponsor
            Card sponsorCard = new Card();
            sponsorCard.setBalance(500);
            Sponsor sponsor1 = new Sponsor("sponsor0","sponsor0",new Email("sponsor0@gmail.com"),"sponsor0","company0",sponsorCard);
            User user9 = new User("sponsor0","sponsor0",new Email("sponsor0@gmail.com"),"sponsor0",Role.SPONSOR);
            user9.setId("spons1");
            sponsor1.setId("spons1");
            getUserDAO().save(user9);
            getSponsorDAO().save(sponsor1);

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateString;
            String dueDateString;
            Date date;
            Date dueDate;
            Participation participation;

            //create races

            dateString = "30-04-2022";
            dueDateString = "20-04-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race1 = new Race("freestyle biking", new Place("Athens", "Nea Ionia"), date, RaceType.STREET, 150,
                     dueDate, organizer1, new Money(15.0), new Money(10.0));

            race1.setReferee(referee1);
            race1.setId("race1Id");
            Participation part1=(new Participation(competitor1,race1));
            Participation part2=(new Participation(competitor2,race1));
            part1.setId(1);
            part2.setId(2);
            race1.addParticipant(part1); //tolis in race 1
            race1.addParticipant(part2); //nikos in race 1
            getRaceDao().save(race1);


            Race race2 = new Race("mountain adventures", new Place("Giannena", "Litharitsia"), date, RaceType.OFFROAD, 100,
                    dueDate, organizer2, new Money(10.0), new Money(700.0));
            race2.setId("race2Id");
            race2.setReferee(referee2);
            Participation part5=(new Participation(competitor2,race2));// nikos in race2
            Participation part6=(new Participation(competitor3,race2));// stathis in race2
            part5.setId(1);
            part6.setId(2);
            race2.addParticipant(part5);
            race2.addParticipant(part6);
            race2.addSponsorshipApplication(new SponsorshipApplication(50.0,sponsor1));
            getRaceDao().save(race2);


            dateString = "15-06-2022";
            dueDateString = "12-06-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race3 = new Race("street lights",new Place("Athens","Hrakleio"),date,RaceType.STREET,200,
                    dueDate,organizer1,new Money(25.0),new Money(3000.0));
            race3.setId("race3Id");
            race3.setReferee(referee2);
            getRaceDao().save(race3);


            dateString = "03-07-2022";
            dueDateString = "28-06-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race4 = new Race("above earth",new Place("Litoxwro","Litoxwro"),date,RaceType.OFFROAD,125,
                    dueDate, organizer2 ,new Money(10.0),new Money(400.0));
            race4.setId("race4Id");
            race4.setReferee(referee1);
            race4.addSponsorshipApplication(new SponsorshipApplication(100.0,sponsor1));
            getRaceDao().save(race4);

            dateString = "30-07-2022";
            dueDateString = "20-07-2022";
            date = formatter.parse(dateString);
            dueDate = formatter.parse(dueDateString);
            Race race5 = new Race("Big race", new Place("Piraeus", "Palia Ionia"), date, RaceType.STREET, 175,
                     dueDate, organizer1, new Money(15.0), new Money(1500.0));

            race5.setReferee(referee2);
            race5.setId("race5Id");
            Participation part3=(new Participation(competitor2,race5));
            Participation part4=(new Participation(competitor3,race5));
            part3.setId(1);
            part4.setId(2);
            race5.addParticipant(part3);
            race5.addParticipant(part4);
            getRaceDao().save(race5);*/

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearData(){

        getRaceDao().clear();
        getCompetitorDao().clear();
        getOrganizerDAO().clear();
        getRefereeDAO().clear();
        getSponsorDAO().clear();
        getUserDAO().clear();
    }

    public abstract RaceDAO getRaceDao();
    public abstract CompetitorDAO getCompetitorDao();
    protected abstract OrganizerDAO getOrganizerDAO();
    protected abstract RefereeDAO getRefereeDAO();
    protected abstract SponsorDAO getSponsorDAO();
    protected abstract UserDAO getUserDAO();
}
