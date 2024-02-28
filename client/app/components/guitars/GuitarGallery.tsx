import React, { useEffect, useState } from "react";
import { GuitarCard } from "./GuitarCard";
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
export const GuitarGallery = () => {
  const [guitars, setGuitars] = useState<Guitar[]>([]);

  useEffect(() => {
    const fetchGuitars = async () => {
      const response = await fetch("http://localhost:8080/api/v1/guitars");
      const jsonResponse = await response.json();
      setGuitars(jsonResponse.guitars);
    };
    fetchGuitars();
  }, []);
  console.log(guitars);
  return (
    <div>
      {guitars.map((guitar, index) => (
        <GuitarCard guitar={guitar} key={index} />
      ))}
    </div>
  );
};
