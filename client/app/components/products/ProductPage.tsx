import { Guitar, Tuner } from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { GuitarInfo } from "../guitars/GuitarInfo";
import { TunerInfo } from "../tuners/TunerInfo";

type Props = {
  productId: string;
};

export const ProductPage = ({ productId }: Props) => {
  const [guitar, setGuitar] = useState<Guitar>();
  const [tuner, setTuner] = useState<Tuner>();
  useEffect(() => {
    const fetchProductById = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/${productId}`
      );
      const responseToJson = await response.json();
      console.log(responseToJson);
      if (responseToJson.category === "guitars") {
        setGuitar(responseToJson);
      } else if (responseToJson.category === "tuners") {
        setTuner(responseToJson);
      }
    };
    fetchProductById();
    console.log(guitar);
    console.log(tuner);
  }, []);

  return (
    <div>
      {guitar && <GuitarInfo guitar={guitar} />}
      {tuner && <TunerInfo tuner={tuner} />}
    </div>
  );
};
