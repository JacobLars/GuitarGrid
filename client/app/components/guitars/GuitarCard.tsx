import Rating from "@mui/material/Rating";
import { Card } from "@nextui-org/react";
import React from "react";

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
};
type Image = {
  id: string;
  url: string;
  isMain: boolean;
};
export const GuitarCard = ({ guitar }: Props) => {
  return (
    <div>
      <Card className="flex items-center h-40 shadow-md m-5">
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
            className="mt-5"
            name="read-only"
            value={guitar.rating}
            readOnly
          />
          <p className="mt-5 text-lg">{guitar.price}$</p>
        </div>
      </Card>
    </div>
  );
};
