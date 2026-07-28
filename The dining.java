class DiningPhilosophers {
    private final Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {
        
        int left = philosopher;
        int right = (philosopher + 1) % 5;
        
        // Break the circular wait: last philosopher picks right fork first
        int first = (philosopher == 4) ? right : left;
        int second = (philosopher == 4) ? left : right;
        
        forks[first].lock();
        forks[second].lock();
        
        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forks[first].unlock();
            forks[second].unlock();
        }
    }
}
