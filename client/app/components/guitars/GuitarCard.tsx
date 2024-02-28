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
};
type Image = {
  id: string;
  url: string;
};
export const GuitarCard = ({ guitar }: Props) => {
  return (
    <div>
      <Card>
        <h1>{guitar.name}</h1>
        <img src={guitar.images[1].url} />
      </Card>
    </div>
  );
};
