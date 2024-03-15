import React, { useState } from "react";
import { FilterByRating } from "./FilterByRating";
import { Product } from "@/app/types/Types";
import { SortByPrice } from "./SortByPrice";
type Props = {
  products: Product[];
  setSelectedRatings: Function;
  selectedRatings: number[];
  setOption: Function;
};
export const FilterMenu = ({
  products,
  setSelectedRatings,
  selectedRatings,
  setOption,
}: Props) => {
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [icon, setIcon] = useState<string>("/filter.png");
  const handleToggle = () => {
    setIsOpen(!isOpen);
    if (isOpen) {
      setIcon("/filter.png");
    } else {
      setIcon("/close.png");
    }
  };
  return (
    <div className="mt-5 mb-16">
      <img
        className="h-8 absolute ml-14 z-10 mt-1"
        src={icon}
        onClick={handleToggle}
      />
      <div
        className={`mx-auto w-3/4 transition-transform ease-out duration-300 ${
          isOpen
            ? "translate-x-0  border border-slate-600 rounded-md shadow-md"
            : "translate-x-full"
        }`}
      >
        {isOpen && (
          <>
            <FilterByRating
              products={products}
              setSelectedRatings={setSelectedRatings}
              selectedRatings={selectedRatings}
            />
            <SortByPrice setOption={setOption} />
          </>
        )}
      </div>
    </div>
  );
};
