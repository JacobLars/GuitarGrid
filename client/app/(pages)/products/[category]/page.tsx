"use client";
import { NavBar } from "@/app/components/navbar/NavBar";

export default function ProductCategory({
  params,
}: {
  params: { type: string };
}) {
  return (
    <div className="">
      <NavBar />
    </div>
  );
}
