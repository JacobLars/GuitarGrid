import { Product } from "@/app/types/Types";
import Rating from "@mui/material/Rating";
type Props = {
  products: Product[];
  setSelectedRatings: Function;
  selectedRatings: number[];
};
export const SortByRating = ({
  products,
  selectedRatings,
  setSelectedRatings,
}: Props) => {
  const handleCheckboxChange = (rating: number) => {
    if (selectedRatings.includes(rating)) {
      setSelectedRatings(selectedRatings.filter((r) => r !== rating));
    } else {
      setSelectedRatings([...selectedRatings, rating]);
    }
  };

  const getProductCountByRating = (rating: number) => {
    return products.filter((product) => product.rating === rating).length;
  };
  return (
    <div className="flex flex-col items-center mt-2">
      <h2 className="underline text-md">Filter by Rating</h2>
      <ul>
        {[5, 4, 3, 2, 1].map((rating) => (
          <li key={rating} className="flex items-center">
            <input
              type="checkbox"
              checked={selectedRatings.includes(rating)}
              onChange={() => handleCheckboxChange(rating)}
            />
            <Rating name="read-only" value={rating} readOnly />
            <p>({getProductCountByRating(rating)})</p>
          </li>
        ))}
      </ul>
    </div>
  );
};
