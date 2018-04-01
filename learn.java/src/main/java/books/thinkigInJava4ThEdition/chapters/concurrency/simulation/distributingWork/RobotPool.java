package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.distributingWork;

import java.util.HashSet;
import java.util.Set;

class RobotPool {
    //quietly prevents identical entries
    private Set<Robot> pool = new HashSet<Robot>();

    synchronized void add(Robot robot) {
        pool.add(robot);
        notifyAll();
    }

    synchronized void hire(Class<? extends Robot> robotType, Assembler assembler) throws InterruptedException {
        for(Robot r : pool) //{ //works without commented out {}
            if(r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(assembler);
                r.engage();  //power it up to do the task
                return;
            }
//        }
        wait();
        hire(robotType, assembler);  //try again recursively
    }

    synchronized void release(Robot robot) {
        add(robot);
    }
}

