package pl.touk.sputnik.review.visitor;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import lombok.extern.slf4j.Slf4j;
import pl.touk.sputnik.review.Review;
import pl.touk.sputnik.review.ReviewFile;

@Slf4j
public class FilterOutTestFilesVisitor implements BeforeReviewVisitor {

    @Override
    public void beforeReview(Review review) {
        log.info("Filtering out test files from review");
        review.setFiles(FluentIterable.from(review.getFiles()).filter(new Predicate<ReviewFile>() {
            @Override
            public boolean apply(ReviewFile file) {
                return !file.isTestFile();
            }
        }).toList());
    }
}
