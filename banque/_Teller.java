package banque;

public class _Teller {
    // start time and end time of current interval
    private int startTime;
    private int endTime;

    // teller id and current customer which is served by this teller
    private int tellerID;
    private _Customer currentCustomer;

    // for keeping statistical data
    private int totalFreeTime;
    private int totalBusyTime;
    private int totalCustomers;

    _Teller() {
        this(1);
    }

    _Teller(int tellerId) {
        tellerID = tellerId;
    }

    // accessor methods

    int getTellerID() {
        return tellerID;
    }

    _Customer getCustomer() {
        return currentCustomer;
    }

    // need this to setup priority queue
    int getEndBusyIntervalTime() {
        // return end time of busy interval
        return endTime;
    }

    // functions for state transition

    void freeToBusy(_Customer currentCustomer, int currentTime) {
        // Main goal : switch from free interval to busy interval
        //
        // end free interval, start busy interval
        // steps : update totalFreeTime
        // set startTime, endTime, currentCustomer
        // update totalCustomers

        totalFreeTime += (currentTime - startTime);
        startTime = currentTime;
        endTime = startTime + currentCustomer.getTransactionTime();
        this.currentCustomer = currentCustomer;
        totalCustomers++;
    }

    _Customer busyToFree() {
        // Main goal : switch from busy interval to free interval
        //
        // steps : update totalBusyTime
        // set startTime
        // return currentCustomer

        totalBusyTime += (endTime - startTime);
        startTime = endTime;
        return currentCustomer;
    }

    // need this method at the end of simulation to update teller data
    // intervalType: 0 for FREE interval, 1 for BUSY interval
    void setEndIntervalTime(int endsimulationtime, int intervalType) {
        // for end of simulation
        // set endTime,
        // for FREE interval, update totalFreeTime
        // for BUSY interval, update totalBusyTime

        endTime = endsimulationtime;

        if (intervalType == 0) {
            totalFreeTime += endTime - startTime;
        } else {
            totalBusyTime += endTime - startTime;
        }
    }

    // functions for printing statistics :

    /*
     * void printStatistics ()
     * {
     * // print teller statistics, see project statement
     * 
     * System.out.println("\t\tTeller ID                : "+tellerID);
     * System.out.println("\t\tTotal free time          : "+totalFreeTime);
     * System.out.println("\t\tTotal busy time          : "+totalBusyTime);
     * System.out.println("\t\tTotal # of customers     : "+totalCustomers);
     * 
     * if (totalCustomers > 0) {
     * System.out.format("\t\tAverage transaction time : %.2f\n",
     * (totalBusyTime*1.0)/totalCustomers);
     * }
     * System.out.println();
     * }
     */

}