"use client";
import { Header } from "@/app/components/header/Header";
import { NavBar } from "@/app/components/navbar/NavBar";
import { ProductPage } from "@/app/components/products/ProductPage";
import { Menu } from "@/app/components/navbar/UserMenu";
import {
  Amplifier,
  Guitar,
  Picks,
  Pickup,
  Product,
  Tuner,
} from "@/app/types/Types";
import { useEffect, useState } from "react";

export default function ProductById({
  params,
}: {
  params: { category: string; id: string };
}) {
  const [product, setProduct] = useState<Product>();
  const [products, setProducts] = useState<Product[]>([]);
  const [guitar, setGuitar] = useState<Guitar>();
  const [tuner, setTuner] = useState<Tuner>();
  const [amplifier, setAmplifier] = useState<Amplifier>();
  const [pickup, setPickup] = useState<Pickup>();
  const [picks, setPicks] = useState<Picks>();
  const [isLoading, setIsLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchProductById = async () => {
      const response = await fetch(
        `http://localhost:8080/api/v1/products/${params.id}`
      );
      const responseToJson = await response.json();
      setProduct(responseToJson);
      if (responseToJson.category === "guitars") {
        setGuitar(responseToJson);
      } else if (responseToJson.category === "tuners") {
        setTuner(responseToJson);
      } else if (responseToJson.category === "amplifiers") {
        setAmplifier(responseToJson);
      } else if (responseToJson.category === "pickups") {
        setPickup(responseToJson);
      } else if (responseToJson.category === "picks") {
        setPicks(responseToJson);
      }
      setIsLoading(false);
    };
    fetchProductById();
  }, []);

  return (
    <div className="">
      <Header />
      <Menu />
      <NavBar />
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        <ProductPage
          productId={params.id}
          productCategory={params.category}
          product={product!}
          guitar={guitar}
          tuner={tuner}
          amplifier={amplifier}
          pickup={pickup}
          picks={picks}
          setProducts={setProducts}
        />
      )}
    </div>
  );
}
