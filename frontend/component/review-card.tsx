import { ReviewModel } from "@/model/review.model";
import { useForm } from 'react-hook-form';
import { zodResolver } from '@hookform/resolvers/zod';
import { z } from 'zod';

const commentSchema = z.object({
  comment: z.string().min(1, "Comment is required"),
});

type FormData = z.infer<typeof commentSchema>;

interface ReviewCardProps {
    className?: string;
    reviewModel: ReviewModel;
}

const ReviewCard: React.FC<ReviewCardProps> = ({ className, reviewModel }) => {
    return (

    );

}

export default ReviewCard;