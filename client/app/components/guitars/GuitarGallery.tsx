import React, { useEffect, useState } from "react";
import { GuitarCard } from "./GuitarCard";
import { Spinner } from "@nextui-org/react";
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
export const GuitarGallery = () => {
  const [guitars, setGuitars] = useState<Guitar[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);
  useEffect(() => {
    const fetchGuitars = async () => {
      const response = await fetch("http://localhost:8080/api/v1/guitars");
      const jsonResponse = await response.json();
      setGuitars(jsonResponse.guitars);
      setIsloading(false);
    };
    fetchGuitars();
  }, []);

  return (
    <div>
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        guitars.map((guitar, index) => (
          <GuitarCard guitar={guitar} key={index} />
        ))
      )}
    </div>
  );
};
