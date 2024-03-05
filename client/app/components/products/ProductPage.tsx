import { Guitar, Image, Tuner } from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { GuitarInfo } from "../guitars/GuitarInfo";
import { TunerInfo } from "../tuners/TunerInfo";
import { Carousel } from "./Carousel";
import { ProductHeader } from "./ProductHeader";
import { PriceInfo } from "./PriceInfo";

type Props = {
  productId: string;
};

export const ProductPage = ({ productId }: Props) => {
  const [guitar, setGuitar] = useState<Guitar>();
  const [tuner, setTuner] = useState<Tuner>();
  const [isLoading, setIsLoading] = useState<boolean>(true);
  useEffect(() => {
    const fetchProductById = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/${productId}`
      );
      const responseToJson = await response.json();
      if (responseToJson.category === "guitars") {
        setGuitar(responseToJson);
        setIsLoading(false);
      } else if (responseToJson.category === "tuners") {
        setTuner(responseToJson);
        setIsLoading(false);
      }
    };
    fetchProductById();
  }, []);

  return (
    <div>
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" alt="Loading" />
      ) : (
        <>
          {guitar && (
            <>
              <ProductHeader
                productName={guitar.name}
                productRating={guitar.rating}
                brandLogo={guitar.brand.logo}
                product_quantity={guitar.product_quantity}
              />
              <Carousel images={guitar.images} />
              <PriceInfo
                product_price={guitar.price}
                product_quantity={guitar.product_quantity}
              />
              <GuitarInfo guitar={guitar} />
            </>
          )}
          {tuner && (
            <>
              <ProductHeader
                productName={tuner.name}
                productRating={tuner.rating}
                brandLogo={tuner.brand.logo}
                product_quantity={tuner.product_quantity}
              />
              <Carousel images={tuner.images} />
              <PriceInfo
                product_price={tuner.price}
                product_quantity={tuner.product_quantity}
              />
              <TunerInfo tuner={tuner} />
            </>
          )}
        </>
      )}
    </div>
  );
};
