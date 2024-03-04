import { Guitar, Image, Tuner } from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { GuitarInfo } from "../guitars/GuitarInfo";
import { TunerInfo } from "../tuners/TunerInfo";
import { Carousel } from "./Carousel";
import { ProductHeader } from "./ProductHeader";

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
  }, []);

  return (
    <div>
      {guitar && (
        <>
          <ProductHeader
            productName={guitar.name}
            productRating={guitar.rating}
            brandLogo={guitar.brand.logo}
          />
          <Carousel images={guitar!.images} />
          <GuitarInfo guitar={guitar} />
        </>
      )}
      {tuner && <Carousel images={tuner!.images} />}
    </div>
  );
};
