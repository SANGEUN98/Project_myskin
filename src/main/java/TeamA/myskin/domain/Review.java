package TeamA.myskin.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Review {
    private int rid;            // 리뷰아이디(PK)
    private int pid;            // 상품아이디(FK)
    private String loginId;     // 회원아이디(FK)

    @NotEmpty
    private double gradeReview;    // 별점(리뷰평점)
    private String review;      // 리뷰내용
    private String inrollDate;  // 리뷰등록일

    public Review() {

    }
    public Review(int rid, int pid, String loginId, double gradeReview, String review, String inrollDate) {
        this.rid = rid;
        this.pid = pid;
        this.loginId = loginId;
        this.gradeReview = gradeReview;
        this.review = review;
        this.inrollDate = inrollDate;
    }
}