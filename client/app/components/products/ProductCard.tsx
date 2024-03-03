import { Image } from "@/app/types/Types";
import Rating from "@mui/material/Rating";
import { Card } from "@nextui-org/react";
import React, { useEffect, useState } from "react";
type Props = {
  id: string;
  name: string;
  price: number;
  rating: number;
  product_quantity: number;
  images: Image[];
  brandName: string;
};
export const ProductCard = ({
  id,
  name,
  price,
  rating,
  product_quantity,
  images,
  brandName,
}: Props) => {
  const [isAvailable, setIsAvailable] = useState<boolean>(true);
  useEffect(() => {
    if (product_quantity === 0) {
      setIsAvailable(false);
    }
  }, []);
  return (
    <div>
      <Card className="flex items-center shadow-lg m-5 border border-[#c5c5c5]">
        <img
          className="w-40 max-h-40 self-start p-5 object-contain -ml-10 overflow-hidden"
          src={images.filter((img) => img.isMain === true)[0].url}
        />
        <div className="ml-10 -mt-36">
          <div className="flex">
            <p className="mr-2 font-bold">{brandName}</p>
            <p>{name}</p>
          </div>
          <Rating className="mt-2" name="read-only" value={rating} readOnly />
          <p className="mt-2 text-lg">{price}$</p>
          {isAvailable ? (
            <p className="text-green-400 mt-2">In stock</p>
          ) : (
            <p className="text-red-600 mt-2">Out of stock</p>
          )}
        </div>
      </Card>
    </div>
  );
};
