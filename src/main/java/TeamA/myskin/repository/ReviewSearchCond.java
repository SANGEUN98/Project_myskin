package TeamA.myskin.repository;

import lombok.Data;

@Data
public class ReviewSearchCond {

    private int pid;

    private int rid;

    public ReviewSearchCond() {
    }

    public ReviewSearchCond(int pid, int rid) {
        this.pid = pid;
        this.rid = rid;
    }
}
