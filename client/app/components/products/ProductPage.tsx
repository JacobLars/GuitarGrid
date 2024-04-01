import {
  Amplifier,
  Guitar,
  Image,
  Picks,
  Pickup,
  Product,
  Tuner,
} from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { GuitarInfo } from "./guitars/GuitarInfo";
import { TunerInfo } from "./tuners/TunerInfo";
import { Carousel } from "./Carousel";
import { ProductHeader } from "./ProductHeader";
import { PriceInfo } from "./PriceInfo";
import { AmplifierInfo } from "./amplifiers/AmplifierInfo";
import { PickupInfo } from "./pickups/PickupInfo";
import { PicksInfo } from "./picks/PicksInfo";

type Props = {
  productId: string;
  productCategory: string;
};

export const ProductPage = ({ productId, productCategory }: Props) => {
  const [guitar, setGuitar] = useState<Guitar>();
  const [tuner, setTuner] = useState<Tuner>();
  const [amplifier, setAmplifier] = useState<Amplifier>();
  const [pickup, setPickup] = useState<Pickup>();
  const [picks, setPicks] = useState<Picks>();
  const [product, setProduct] = useState<Product>();
  const [isLoading, setIsLoading] = useState<boolean>(true);
  useEffect(() => {
    const fetchProductById = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/${productId}`
      );
      const responseToJson = await response.json();
      setProduct(responseToJson);

      if (productCategory === "guitars") {
        setGuitar(responseToJson);
      } else if (productCategory === "tuners") {
        setTuner(responseToJson);
      } else if (productCategory === "amplifiers") {
        setAmplifier(responseToJson);
      } else if (productCategory === "pickups") {
        setPickup(responseToJson);
      } else if (productCategory === "picks") {
        setPicks(responseToJson);
      }
      setIsLoading(false);
    };
    fetchProductById();
  }, []);

  return (
    <div>
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" alt="Loading" />
      ) : (
        <>
          <ProductHeader
            productName={product!.name}
            productRating={product!.rating}
            brandLogo={product!.brandLogo}
            product_quantity={product!.product_quantity}
          />
          <Carousel images={product!.images} />
          <PriceInfo
            product_price={product!.price}
            product_quantity={product!.product_quantity}
          />
          {guitar && <GuitarInfo guitar={guitar} />}
          {tuner && <TunerInfo tuner={tuner} />}
          {amplifier && <AmplifierInfo amplifier={amplifier} />}
          {pickup && <PickupInfo pickup={pickup} />}
          {picks && <PicksInfo picks={picks} />}
        </>
      )}
    </div>
  );
};
