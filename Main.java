import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        List<User> users = new ArrayList<>();

        int i = 0, loggedUser = -1, choose = 0, tempChoose = 0;
        char WannaComment = 'y';

        Scanner sc = new Scanner (System.in);

        while (true){
            System.out.println("SOCIAL TUNE");
            System.out.println("                 {SOCIAL TUNE(/) - CONECTING DEV'S}");
            System.out.println();
            do{
                System.out.println("{1} NEW ACCOUNT ~ {2} LOGIN");
                System.out.println(":$~");
                choose = sc.nextInt();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                switch ( choose) {
                case 1:
                    sc.nextLine();
                    System.out.print("E-MAIL:~$ ");
                    String email = sc.nextLine();
                    System.out.print("PASSWORD:~$ ");
                    String password = sc.nextLine();
                    System.out.print("FULL NAME:~$ ");
                    String name = sc.nextLine();
                    System.out.print("BIRTHDATE dd/MM/yyyy:~$");
                    String birthdate = sc.nextLine();
                    System.out.print("RELATIONSHIP:$ ");
                    String relationship = sc.nextLine();
                    System.out.println();
                    users.add(new User(email, password, name, birthdate, relationship));
                    break;
                case 2:
                    sc.nextLine();
                    do{
                        System.out.print("E-MAIL:~$ ");
                        String emailCheck = sc.nextLine();
                        System.out.print("PASSWORD:~$ ");
                        String passwordCheck = sc.nextLine();
                        System.out.println();
                        for (i = 0; i < users.size(); i++) {
                            if (users.get(i).getEmail().contentEquals(emailCheck) && users.get(i).getPassword().contentEquals(passwordCheck)){
                                loggedUser = i;
                                break;
                            }

                        }
                    } while (loggedUser < 0);
                }
            } while (loggedUser < 0);

            do{
                System.out.println();
                System.out.println("SOCIAL TUNE");
                System.out.println("                 {SOCIAL TUNE(/) - CONECTING DEV'S}");
                System.out.println();
                System.out.println("                  {LOGGED AS" + users.get(loggedUser).getName() + "}");
                users.get(loggedUser).showFriends();
                users.get(loggedUser).showPosts();
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("{1} USER SETTINGS");
                System.out.println("{2} POSTS");
                System.out.println();

                if(choose ==1) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("{WHICH INFORMATION DO YOU WANT SET?}");
                    System.out.println();
                    System.out.println("[1] E-MAIL: " + users.get(loggedUser).getEmail());
                    System.out.println("[2] PASSWORD: " + users.get(loggedUser).getPassword());
                    System.out.println("[3] NAME: " + users.get(loggedUser).getName());
                    System.out.println("[4] BIRTHDATE (dd/mm/yyyy): " + users.get(loggedUser).getBirthdate());
                    System.out.println("[5] RELATIONSHIP: " + users.get(loggedUser).getRelationship());
                    System.out.println("[6] MAIN MENU");
                    System.out.println(":~$ ");
                    tempChoose = sc.nextInt();
                    switch (tempChoose) {
                    case 1:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("{CURRENT E-MAIL} " + users.get(loggedUser).getEmail());
                        System.out.println();
                        sc.nextLine();
                        System.out.println("NEW E-MAIL:~$ ");
                        String newEmail = sc.nextLine();
                        System.out.println();
                        users.get(loggedUser).setEmail(newEmail);
                        break;

                    case 2:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.print("{CURRENT PASSWORD} " + users.get(loggedUser).getPassword());
                        System.out.println();
                        sc.nextLine();
                        System.out.print("NEW PASSWORD:~$ ");
                        String newPassword = sc.nextLine();
                        System.out.println();
                        users.get(loggedUser).setPassword(newPassword);
                        break;
                    case 3:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.print("{CURRENT FULL NAME} " + users.get(loggedUser).getName());
                        System.out.println();
                        sc.nextLine();
                        System.out.print("NEW FULL NAME:~$ ");
                        String newName = sc.nextLine();
                        System.out.println();
                        users.get(loggedUser).setName(newName);
                        break;
                    case 4:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.print("{CURRENT BIRTHDATE} " + users.get(loggedUser).getBirthdate());
                        System.out.println();
                        sc.nextLine();
                        System.out.print("NEW BIRTHDATE:~$ ");
                        String newBirthdate = sc.nextLine();
                        System.out.println();
                        users.get(loggedUser).setBirthdate(newBirthdate);
                        break;
                    case 5:
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.print("{CURRENT RELATIONSHIP} " + users.get(loggedUser).getRelationship());
                        System.out.println();
                        sc.nextLine();
                        System.out.print("NEW RELATIONSHIP STATUS:~$ ");
                        String newRelationship = sc.nextLine();
                        System.out.println();
                        users.get(loggedUser).setRelationship(newRelationship);
                        break;
                    case 6:
                        break;
                    }

                }
                if (choose ==2) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("{POSTS}");
                    System.out.println();
                    System.out.println("{1} WHATS ON YOUR MIND?");
                    System.out.println("{2} LIST YOUR POST");
                    System.out.println("{3} LIST ALL POSTS?");
                    System.out.println("{4} MAIN MENU");
                    System.out.println(":~$ ");
                    System.out.println();
                    tempChoose = sc.nextInt();
                    System.out.println();
                    switch (tempChoose) {
                    case 1:
                        System.out.print("POST ID:~$ ");
                        Integer idPost = sc.nextInt();
                        sc.nextLine();
                        System.out.print("POST CONTENT:~$ ");
                        String content = sc.nextLine();
                        users.get(loggedUser).addPost(users.get(loggedUser), idPost, content);
                        System.out.println();
                        break;
                    case 2:
                        if (users.get(loggedUser). getPosts().isEmpty()){
                            System.out.println("{YOU DON'T HAVE ANY POST YET}");

                        } else {
                            users.get(loggedUser).showPosts();
                            do {
                                System.out.println();
                                System.out.println("{1} EDIT POST ~ {2} REMOVE POST ~ {3} MAIN MENU");
                                tempChoose = sc.nextInt();
                                System.out.println();
                                switch (tempChoose) {
                                case 1:
                                    sc.nextLine();
                                    users.get(loggedUser).showYourPosts();
                                    System.out.println();
                                    sc.nextLine();
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.print("SELECT THE ID OF THE POST THAT YOU WANT TO EDIT:~$ ");
                                    Integer postId = sc.nextInt();
                                    System.out.println();
                                    sc.nextLine();
                                    System.out.print("WEITE A NEW CONTENT:~$ ");
                                    String editContent = sc.nextLine();
                                    users.get(loggedUser).editPost(postId, editedContent);
                                    break;
                                    case 2:
                                    sc.nextLine();
                                    users.get(loggedUser).showPosts();
                                    System.out.print("SELECT THE ID POST THAT YOU WANT TO REMOVE:~$ ");
                                    postId = sc.nextInt();
                                    users.get(loggedUser).removePost(postId);
                                    break;
                                case 3:
                                    break;
                                }

                            } while(tempChoose != 3);

                        }
                        break;
                    case 3:
                        for(i = 0; i < users.size(); i++) {
                            if (users.get(i).getPosts().isEmpty()){

                            } else{
                                users.get(i).showPosts();
                                System.out.println();
                            }
                        }
                        do {
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("{1} TO MAKE A COMMENT");
                            System.out.println("{2} TO EDIT A COMMENT");
                            System.out.println("{3} TO DELETE A COMMENT");
                            System.out.println("{4} MAIN MENU");
                            System.out.println(":~$ ");
                            tempChoose = sc.nextInt();
                            switch (tempChoose) {
                            case 1:
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                while (WannaComment == 'Y' || wannaComment == 'y') {
                                    sc.nextLine();
                                    System.out.print("SELECT THE ID OF THE POST THAT WANT TO COMMENT:~$ ");
                                    Integer idPostComment = sc.nextInt();
                                    System.out.print("COMMENT TEXT:~$ ");
                                    Integer textComment = sc.nextInt();
                                    for(i = 0; i < users.size(); i++);
                                    for(int j = 0; j < users.get(i).getPosts().size(); j++ ) {
                                        if (users.get(i).getPosts().get(j).getIdPost() == idPostComment) {
                                            users.get(i).getPosts().get(j).addComment (idComment, users.get(loggedUser), textComment);
                                        }

                                    }

                                }
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println();
                            }
                        }

                    }


                }


            }
        }

        
    }
    
}
