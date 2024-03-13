import { Brand } from "@/app/types/Types";
import React, { useEffect, useState } from "react";
import { BrandCard } from "./BrandCard";

export const BrandGallery = () => {
  const [brands, setBrands] = useState<Brand[]>([]);
  useEffect(() => {
    const fetchAllBrands = async () => {
      const response = await fetch("http://localhost:8080/api/v1/brands");
      const responseToJson = await response.json();
      setBrands(responseToJson.brands);
    };
    fetchAllBrands();
  }, []);

  return (
    <div className="mt-10">
      <h1 className="text-2xl text-center underline">Our Brands</h1>
      <div className="grid grid-cols-3 gap-3 mt-5 m-2">
        {brands.map((brand, index) => (
          <BrandCard brand={brand} key={index} />
        ))}
      </div>
    </div>
  );
};
