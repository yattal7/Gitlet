package gitlet;

import java.io.File;
import java.lang.Error;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/** Driver class for Gitlet, the tiny stupid version-control system.
 *  @author Yash Attal and Kadhir Manickam
 */
public class Main implements Serializable {
	private ArrayList<File> stagedArea;
	private ArrayList<File> workingArea;
	private ArrayList<File> removedArea;

    /** Initializes a new Main class. Returns a new Main class 
     and should only be used when initializes Gitlet and the
     rest would use the same file. */
    public Main() {
        stagedArea = new ArrayList<File>();
        workingArea = new ArrayList<File>();
        removedArea = new ArrayList<File>();
    }

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND> .... */
    public static void main(String... args) {
        if (args.length == 0) {
            throw new Error("Please enter a command.");
        }
        Main myMain = Main.loadGit();
        if (myMain == null) {
        	myMain = new Main();
        }
        String command = args[0];
        switch (command) {
            case "init":
                myMain.initCommand();
                break;
            case "add":
                String fileName = args[1];
                myMain.addCommand(fileName);
                break;
            case "commit":
                String message = args[1];
                myMain.commitCommand(message);
                break;
            case "rm":
                String fileName = args[1];
                myMain.rmCommand(fileName);
                break;
            case "log":
                myMain.logCommand();
                break;
            case "global-log":
                myMain.globalLogCommand();
                break;
            case "find":
                String commitMessage = args[1]
                myMain.findCommand(commitMessage);
                break;
            case "status":
                myMain.statusCommand():
                break;
            case "checkout":
                myMain.checkoutCommand(args[1:]);
                break;
            case "rm-branch":
                String branchName = args[1]
                myMain.rmBranchCommand(branchName);
                break;
            case "reset":
                String commitID = args[1]
                myMain.resetCommand(commitID);
                break;
            case "merge":
                String branchName = args[1]
                myMain.mergeCommand(branchName);
                break;
            default:
                throw new Error("No command with that name exists.");
       }
       Main.saveGit(myMain);
    }

    /** The command creates a new Directory called .gitlet
     *  and will return an error if the directory has been
     *  created. */
    public void initCommand() {
        File dir = new File(".gitlet");
        if (dir.exists()) {
            throw new Error("A gitlet version-control
                system already exists in the current directory.")
        }
        dir.mkdir();
        this.commit("initial commit");
    }

    /** The command takes in a string FILENAME and adds a 
     * new file with that name from the working area to the 
     * staging area. */
    public void addCommand(String fileName) {
    	File result = new File(fileName);
    	if (f.exists()) {
    		stagedArea.add(result);
    	}
    	throw new Error("File does not exist.")
    }

    /** Will update the files that were tracked at the time of 
     *  the commit. */
    public void commitCommand(String message) {

    }

    public void rmCommand(String fileName) {

    }

    public void logCommand() {

    }

    public void globalLogCommand() {

    }

    public void findCommand(String commitMessage) {

    }

    public void statusCommand() {

    }

    public void checkoutCommand(String[] args) {

    }

    public void rmBranchCommand(String branchName) {

    }

    public void resetCommand(String commitID) {

    }

    public void mergeCommand(String branchName) {

    }

    /** Hilfinger's psuedocode on how to save my gitlet directory.
      Takes in a NEWGIT and writes a byte file to save the changes
      made to the gitlet directory. */
    public static saveGit(Main newGit) {
        File outFile = new File("gitletCode");
        try {
        	ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(obj);
            out.close();
        } catch (IOException excp) {

        }
    }

    /** Hilfinger's psuedocode on how to load a gitlet directory.
      Uses a file that has already been in place and returns a new object
      Main in order to continue working off of the directory. */
    public static Main loadGit() {
    	Main obj;
    	File inFile = new File(someFileName);
        try {
            ObjectInputStream inp =
                new ObjectInputStream(new FileInputStream(inFile));
            obj = (MyObject) inp.readObject();
            inp.close();
        } catch (IOException | ClassNotFoundException excp) {
            ...
            obj = null;
        }
    }
}
