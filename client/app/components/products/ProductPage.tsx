import {
  Amplifier,
  Guitar,
  Image,
  Picks,
  Pickup,
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
  const [isLoading, setIsLoading] = useState<boolean>(true);
  useEffect(() => {
    const fetchProductById = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/${productId}`
      );
      const responseToJson = await response.json();
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
          {guitar && (
            <>
              <ProductHeader
                productName={guitar.name}
                productRating={guitar.rating}
                brandLogo={guitar.brandLogo}
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
                brandLogo={tuner.brandLogo}
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
          {amplifier && (
            <>
              <ProductHeader
                productName={amplifier.name}
                productRating={amplifier.rating}
                brandLogo={amplifier.brandLogo}
                product_quantity={amplifier.product_quantity}
              />
              <Carousel images={amplifier.images} />
              <PriceInfo
                product_price={amplifier.price}
                product_quantity={amplifier.product_quantity}
              />
              <AmplifierInfo amplifier={amplifier} />
            </>
          )}
          {pickup && (
            <>
              <ProductHeader
                productName={pickup.name}
                productRating={pickup.rating}
                brandLogo={pickup.brandLogo}
                product_quantity={pickup.product_quantity}
              />
              <Carousel images={pickup.images} />
              <PriceInfo
                product_price={pickup.price}
                product_quantity={pickup.product_quantity}
              />
              <PickupInfo pickup={pickup} />
            </>
          )}
          {picks && (
            <>
              <ProductHeader
                productName={picks.name}
                productRating={picks.rating}
                brandLogo={picks.brandLogo}
                product_quantity={picks.product_quantity}
              />
              <Carousel images={picks.images} />
              <PriceInfo
                product_price={picks.price}
                product_quantity={picks.product_quantity}
              />
              <PicksInfo picks={picks} />
            </>
          )}
        </>
      )}
    </div>
  );
};
