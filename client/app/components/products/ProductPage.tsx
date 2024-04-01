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
  product: Product;
  guitar: Guitar | undefined;
  tuner: Tuner | undefined;
  amplifier: Amplifier | undefined;
  pickup: Pickup | undefined;
  picks: Picks | undefined;
  setProducts: Function;
};

export const ProductPage = ({
  product,
  guitar,
  tuner,
  amplifier,
  pickup,
  picks,
  setProducts,
}: Props) => {
  return (
    <div>
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
          setCartProducts={setProducts}
          product={product}
        />
        {guitar && <GuitarInfo guitar={guitar} />}
        {tuner && <TunerInfo tuner={tuner} />}
        {amplifier && <AmplifierInfo amplifier={amplifier} />}
        {pickup && <PickupInfo pickup={pickup} />}
        {picks && <PicksInfo picks={picks} />}
      </>
    </div>
  );
};
