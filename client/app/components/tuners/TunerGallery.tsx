import { Tuner } from "@/app/types/Types";
import { useParams } from "next/navigation";
import React, { useEffect, useState } from "react";
import { ProductCard } from "../products/ProductCard";

export const TunerGallery = () => {
  const [tuners, setTuners] = useState<Tuner[]>([]);
  const [isLoading, setIsloading] = useState<boolean>(true);

  useEffect(() => {
    const fetchTuners = async () => {
      const response = await fetch(`http://localhost:8080/api/v1/tuners`);
      const jsonResponse = await response.json();
      setTuners(jsonResponse.tuners);
      setIsloading(false);
    };
    fetchTuners();
  }, []);
  console.log(tuners);
  return (
    <div>
      {tuners.map((tuner, index) => (
        <ProductCard product={tuner} key={index} />
      ))}
    </div>
  );
};
