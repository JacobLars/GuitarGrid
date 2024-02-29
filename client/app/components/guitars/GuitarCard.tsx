import Rating from "@mui/material/Rating";
import { Card } from "@nextui-org/react";
import React, { useEffect, useState } from "react";

type Props = {
  guitar: Guitar;
};
type Guitar = {
  id: string;
  name: string;
  price: number;
  color: string;
  bodyType: string;
  neckType: string;
  fretboardType: string;
  pickups: string;
  frets: number;
  scale: number;
  images: Image[];
  brandName: string;
  brandLogo: string;
  rating: number;
  product_quantity: number;
};
type Image = {
  id: string;
  url: string;
  isMain: boolean;
};
export const GuitarCard = ({ guitar }: Props) => {
  const [isAvailable, setIsAvailable] = useState<boolean>(true);
  useEffect(() => {
    if (guitar.product_quantity === 0) {
      setIsAvailable(false);
    }
  }, []);

  return (
    <div>
      <Card className="flex items-center shadow-lg m-5 border border-[#c5c5c5]">
        <img
          className="w-40 max-h-40 self-start p-5 object-contain -ml-10"
          src={guitar.images.filter((img) => img.isMain === true)[0].url}
        />
        <div className="-mt-36 ml-20">
          <div className="flex">
            <p className="mr-2 font-bold">{guitar.brandName}</p>
            <p>{guitar.name}</p>
          </div>
          <Rating
            className="mt-2"
            name="read-only"
            value={guitar.rating}
            readOnly
          />
          <p className="mt-2 text-lg">{guitar.price}$</p>
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
